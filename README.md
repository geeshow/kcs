# 서울시 소상공인 상권분석 서비스 API 개발

## 주요 개발 환경
- Java 17
- Spring Boot 3.3.1
- Querydsl 5.0.0
- H2 Database
- Gradle 8.8
- Junit 5
- Lombok

## 프로젝트 실행 방법
1. 프로젝트를 클론
```shell
git clone https://github.com/geeshow/kcs.git
```

2. 프로젝트 빌드
```shell
./gradlew clean build
```

3. 프로젝트 실행
```shell
java -jar build/libs/kcs-0.0.1-SNAPSHOT.jar
```

## 접속 정보
- H2 Database Console : http://localhost:8080/h2-console
  - JDBC URL : jdbc:h2:~/kcs-kyutae
- Swagger : http://localhost:8080/swagger-ui.html

## Model 구조
- SvcIndutyMst : 서비스 업종 코드 정보
- TrdarMst : 상권 코드 정보
- TrdarSeMst : 상권 구분 코드 정보
- TrdarSalesDtl : 상권 매출 정보
- TrdarStorDtl : 상권 분석 정보

![ERD](https://geeshow.github.io/images/image.png)

## 1. CSV 파일 일괄 등록
> 일괄 파일 등록은 두 종류의 데이터셋을 이용합니다.

개업률, 폐업률, 점포수에 대한 정보 : 
[서울시 상권분석서비스(점포-상권)](https://data.seoul.go.kr/dataList/OA-15577/S/1/datasetView.do)


상권 매출 정보 :
[서울시 상권정보(상권-추정매출)](https://data.seoul.go.kr/dataList/OA-15573/S/1/datasetView.do)


### 1.1 등록 프로세스
1. `application.yml`의 `kcs.data.load-enabled`을 이용해 데이터 로드를 활성화합니다.
2. `DataLoaderRunner` 클래스가 자동으로 실행됩니다.(`ApplicationReadyEvent` 적용)

#### 1.1.1 상권 분석 정보(trdar)
- 데이터 위치 : `resources/trdar`
- 데이터 타입 : `LoaderTrdarDto` 

#### 1.1.2 상권 매출 정보(sales)
- 데이터 위치 : `resources/sales`
- 데이터 타입 : `LoaderSalesDto` 

## 2. API 명세

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

### 2.2. 가장 많은 점포수를 가진 업종 목록 조회 API
- REQUEST

| Parameter | Type | Description               |
| --- | --- |---------------------------|
| stdrYyquCd | String | 기준 년도 분기 코드               |
| trdarCd | String | 상권 코드                     |
| topN | Integer | 상위 몇개의 업종을 조회할지 지정(기본값:5) |

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
- `Mockito` : 외부 모듈의 의존성을 제거
- `DataJpaTest` : 실제 데이터와 격리된 상태에서 테스트를 진행
