# 서울시 소상공인 상권분석 서비스 API 개발

## 주요 개발 환경
- Java 17
- Spring Boot 3.3.1
- Querydsl 5.0.0
- H2 Database
- Gradle 8.8
- Junit 5
- Lombok

## 접속 정보
- H2 Database Console : http://localhost:8080/h2-console
  - Database URL : jdbc:h2:~/kcs-kyutae
- Swagger : http://localhost:8080/swagger-ui.html

## Model 구조
- SvcIndutyMst : 서비스 업종 코드 정보
- TrdarMst : 상권 코드 정보
- TrdarSeMst : 상권 구분 코드 정보
- TrdarSalesDtl : 상권 매출 정보
- TrdarStorDtl : 상권 분석 정보

## 1. CSV 파일 일괄 등록
> 일괄 파일 등록은 과제의 요청과 달리 두가지 종류의 데이터셋을 이용합니다.

개업률, 폐업률, 점포수에 대한 정보는 `서울시 상권분석서비스(점포-상권)`를 이용했으며,

> https://data.seoul.go.kr/dataList/OA-15577/S/1/datasetView.do

상권 매출 정보는 `서울시 상권정보(상권-추정매출)`를 이용했습니다.
> https://data.seoul.go.kr/dataList/OA-15573/S/1/datasetView.do

### 1.1 등록 프로세스
1. 등록 프로세스는 `application.yml`의 `kcs.data` 위치에서 실행여부(`load-enabled`)와 파일 위치를 설정할 수 있습니다.
2. `ApplicationReadyEvent` 이벤트를 사용해 스프링부트 실행 시 `DataLoaderRunner` 클래스가 자동으로 실행되도록 했습니다..
3. `CsvFileLoader` 클래스를 사용하여 `resources` 폴더에 있는 CSV 파일을 불러옵니다.
4. `CsvFileLoader` 클래스는 CSV 포맷 전용이며, `FileLoader` 인터페이스를 구현하고, JSON, XML 파일을 로드하는 클래스를 추가할 수 있습니다. 

#### 1.1.1 상권 분석 정보(trdar)
- `CsvFileLoader` 클래스를 사용하여 `resources/trdar` 파일 목록을 불러 옵니다.
- 각 행은 `LoaderTrdarDto` DTO로 매핑되며, `ImportTrdarService`를 사용하여 데이터베이스에 등록합니다. 

#### 1.1.2 상권 매출 정보(sales)
- `CsvFileLoader` 클래스를 사용하여 `resources/sales` 파일 목록을 불러 옵니다.
- 각 행은 `LoaderSalesDto` DTO로 매핑되며, `ImportSalesService`를 사용하여 데이터베이스에 등록합니다. 

## 2. API 구현
- 과제로 요청된 API들은 `KcsTrdarController`, `KcsTrdarService` 클래스에 구현되어 있습니다.
- 데이터 조회는 `Querydsl`을 사용하여 구현되었으며, `TrdarSalesDtlQueryRepository`, `TrdarStorDtlQueryRepository` 클래스에 구현되었습니다.

### 2.1 개업률 및 폐업률 조회 API
- REQUEST

| Parameter | Type | Description | 
| --- | --- | --- |
| stdrYyquCd | String | 기준 년도 분기 코드 |
| trdarCd | String | 상권 코드 |

```shell
curl -X 'POST' \
  'http://localhost:8080/kcs/api/rate' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "stdrYyquCd": "20231",
  "trdarCd": "3001491"
}'
```
- RESPONSE
```json
{
  "topOpenRate": {
    "svcIndutyCd": "CS200017",
    "svcIndutyNm": "골프연습장"
  },
  "topCloseRate": {
    "svcIndutyCd": "CS200013",
    "svcIndutyNm": "기타법무서비스"
  }
}
```
- 개업률, 폐업률은 쿼리를 단순하게 만들기 위해 따로 쿼리를 구현 했습니다.
- `상권 분석 정보`, `서비스 업종 코드 정보`를 조인하여 조회합니다.

### 2.2. 가장 많은 점포수를 가진 업종 목록 조회 API
- REQUEST

| Parameter | Type | Description |
| --- | --- | --- |
| stdrYyquCd | String | 기준 년도 분기 코드 |
| trdarCd | String | 상권 코드 |
| topN | Integer | 상위 몇개의 업종을 조회할지 |

```shell
curl -X 'POST' \
  'http://localhost:8080/kcs/api/top-stor-count' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "stdrYyquCd": "20231",
  "trdarCd": "3001491",
  "topN": 5
}'
```
- RESPONSE
```json
[
  {
    "rank": 1,
    "topStorCount": {
      "svcIndutyCd": "CS300011",
      "svcIndutyNm": "일반의류"
    }
  },
...
  {
    "rank": 5,
    "topStorCount": {
      "svcIndutyCd": "CS100010",
      "svcIndutyNm": "커피-음료"
    }
  }
]
```
- 입력 값에 상위 몇개의 업종을 조회할지 정할 수 있습니다.
- `상권 분석 정보`, `서비스 업종 코드 정보`를 조인하여 조회합니다.

### 2.3. 당월 매출 금액이 가장 높은 상권코드를 조회하는 API
- REQUEST

| Parameter | Type | Description |
| --- | --- | --- |
| stdrYyquCd | String | 기준 년도 분기 코드 |
| svcIndutyCdNm | String | 서비스 업종 코드명 |

```shell
curl -X 'POST' \
  'http://localhost:8080/kcs/api/best-sales' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "stdrYyquCd": "20221",
  "svcIndutyCdNm": "음식점"
}'
```
- RESPONSE
```json
{
  "trdarCd": "3111014"
}
```
- `svcIndutyCdNm` 입력값으로 LIKE 검색을 진행합니다.
- `상권 매출 정보`, `서비스 업종 코드 정보`를 조인하여 조회합니다.

## 오류 처리
### 1. Exception 계층 구조
- 본 프로젝트의 비즈니스 오류는 `KcsRuntimeException`를 이용합니다.

### 2. 오류 응답 구조
- `ErrorResponseDto` 클래스를 사용하여 오류 응답을 구조화하고, 클라이언트에게 전달합니다.
```json
{
  "error": "오류 메시지",
  "exception": "오류 타입"
}
```

## Test 코드
- 기본적으로 단위테스트는 `Mockito`를 적용해 외부 모듈의 의존성을 제거하였고, 해당 함수의 코드 테스트에 집중하였습니다.
- `Querydsl`을 사용한 쿼리 테스트는 `DataJpaTest`를 사용하여 실제 데이터와 격리된 상태에서 테스트를 진행하였습니다.
