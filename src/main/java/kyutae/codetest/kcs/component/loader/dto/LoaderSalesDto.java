package kyutae.codetest.kcs.component.loader.dto;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.csv.CSVRecord;

@Getter
@Setter
public class LoaderSalesDto implements LoaderInterface {
    private String stdrYyquCd; // 기준_년분기_코드
    private String trdarSeCd; // 상권_구분_코드
    private String trdarSeCdNm; // 상권_구분_코드_명
    private String trdarCd; // 상권_코드
    private String trdarCdNm; // 상권_코드_명
    private String svcIndutyCd; // 서비스_업종_코드
    private String svcIndutyCdNm; // 서비스_업종_코드_명
    private long mthSaleAmt; // 당월_매출_금액
    private long mthSaleCnt; // 당월_매출_건수
    private long weekdayAvgSaleAmt; // 주중_매출_금액
    private long holidayAvgSaleAmt; // 주말_매출_금액
    private long monSaleAmt; // 월요일_매출_금액
    private long tueSaleAmt; // 화요일_매출_금액
    private long wedSaleAmt; // 수요일_매출_금액
    private long thuSaleAmt; // 목요일_매출_금액
    private long friSaleAmt; // 금요일_매출_금액
    private long satSaleAmt; // 토요일_매출_금액
    private long sunSaleAmt; // 일요일_매출_금액
    private long tmzon00SaleAmt; // 시간대_00~06_매출_금액
    private long tmzon06SaleAmt; // 시간대_06~11_매출_금액
    private long tmzon11SaleAmt; // 시간대_11~14_매출_금액
    private long tmzon14SaleAmt; // 시간대_14~17_매출_금액
    private long tmzon17SaleAmt; // 시간대_17~21_매출_금액
    private long tmzon21SaleAmt; // 시간대_21~24_매출_금액
    private long maleSaleAmt; // 남성_매출_금액
    private long femaleSaleAmt; // 여성_매출_금액
    private long ageG10SaleAmt; // 연령대_10_매출_금액
    private long ageG20SaleAmt; // 연령대_20_매출_금액
    private long ageG30SaleAmt; // 연령대_30_매출_금액
    private long ageG40SaleAmt; // 연령대_40_매출_금액
    private long ageG50SaleAmt; // 연령대_50_매출_금액
    private long ageG60UppSaleAmt; // 연령대_60_이상_매출_금액
    private long weekdayAvgSaleCnt; // 주중_매출_건수
    private long holidayAvgSaleCnt; // 주말_매출_건수
    private long monSaleCnt; // 월요일_매출_건수
    private long tueSaleCnt; // 화요일_매출_건수
    private long wedSaleCnt; // 수요일_매출_건수
    private long thuSaleCnt; // 목요일_매출_건수
    private long friSaleCnt; // 금요일_매출_건수
    private long satSaleCnt; // 토요일_매출_건수
    private long sunSaleCnt; // 일요일_매출_건수
    private long tmzon00SaleCnt; // 시간대_건수~06_매출_건수
    private long tmzon06SaleCnt; // 시간대_건수~11_매출_건수
    private long tmzon11SaleCnt; // 시간대_건수~14_매출_건수
    private long tmzon14SaleCnt; // 시간대_건수~17_매출_건수
    private long tmzon17SaleCnt; // 시간대_건수~21_매출_건수
    private long tmzon21SaleCnt; // 시간대_건수~24_매출_건수
    private long maleSaleCnt; // 남성_매출_건수
    private long femaleSaleCnt; // 여성_매출_건수
    private long ageG10SaleCnt; // 연령대_10_매출_건수
    private long ageG20SaleCnt; // 연령대_20_매출_건수
    private long ageG30SaleCnt; // 연령대_30_매출_건수
    private long ageG40SaleCnt; // 연령대_40_매출_건수
    private long ageG50SaleCnt; // 연령대_50_매출_건수
    private long ageG60UppSaleCnt; // 연령대_60_이상_매출_건수

    @Override
    public void mapFromCsvRecord(CSVRecord record) {
        stdrYyquCd = record.get("기준_년분기_코드");
        trdarSeCd = record.get("상권_구분_코드");
        trdarSeCdNm = record.get("상권_구분_코드_명");
        trdarCd = record.get("상권_코드");
        trdarCdNm = record.get("상권_코드_명");
        svcIndutyCd = record.get("서비스_업종_코드");
        svcIndutyCdNm = record.get("서비스_업종_코드_명");
        mthSaleAmt = Long.parseLong(record.get("당월_매출_금액"));
        mthSaleCnt = Long.parseLong(record.get("당월_매출_건수"));
        weekdayAvgSaleAmt = Long.parseLong(record.get("주중_매출_금액"));
        holidayAvgSaleAmt = Long.parseLong(record.get("주말_매출_금액"));
        monSaleAmt = Long.parseLong(record.get("월요일_매출_금액"));
        tueSaleAmt = Long.parseLong(record.get("화요일_매출_금액"));
        wedSaleAmt = Long.parseLong(record.get("수요일_매출_금액"));
        thuSaleAmt = Long.parseLong(record.get("목요일_매출_금액"));
        friSaleAmt = Long.parseLong(record.get("금요일_매출_금액"));
        satSaleAmt = Long.parseLong(record.get("토요일_매출_금액"));
        sunSaleAmt = Long.parseLong(record.get("일요일_매출_금액"));
        tmzon00SaleAmt = Long.parseLong(record.get("시간대_00~06_매출_금액"));
        tmzon06SaleAmt = Long.parseLong(record.get("시간대_06~11_매출_금액"));
        tmzon11SaleAmt = Long.parseLong(record.get("시간대_11~14_매출_금액"));
        tmzon14SaleAmt = Long.parseLong(record.get("시간대_14~17_매출_금액"));
        tmzon17SaleAmt = Long.parseLong(record.get("시간대_17~21_매출_금액"));
        tmzon21SaleAmt = Long.parseLong(record.get("시간대_21~24_매출_금액"));
        maleSaleAmt = Long.parseLong(record.get("남성_매출_금액"));
        femaleSaleAmt = Long.parseLong(record.get("여성_매출_금액"));
        ageG10SaleAmt = Long.parseLong(record.get("연령대_10_매출_금액"));
        ageG20SaleAmt = Long.parseLong(record.get("연령대_20_매출_금액"));
        ageG30SaleAmt = Long.parseLong(record.get("연령대_30_매출_금액"));
        ageG40SaleAmt = Long.parseLong(record.get("연령대_40_매출_금액"));
        ageG50SaleAmt = Long.parseLong(record.get("연령대_50_매출_금액"));
        ageG60UppSaleAmt = Long.parseLong(record.get("연령대_60_이상_매출_금액"));
        weekdayAvgSaleCnt = Long.parseLong(record.get("주중_매출_건수"));
        holidayAvgSaleCnt = Long.parseLong(record.get("주말_매출_건수"));
        monSaleCnt = Long.parseLong(record.get("월요일_매출_건수"));
        tueSaleCnt = Long.parseLong(record.get("화요일_매출_건수"));
        wedSaleCnt = Long.parseLong(record.get("수요일_매출_건수"));
        thuSaleCnt = Long.parseLong(record.get("목요일_매출_건수"));
        friSaleCnt = Long.parseLong(record.get("금요일_매출_건수"));
        satSaleCnt = Long.parseLong(record.get("토요일_매출_건수"));
        sunSaleCnt = Long.parseLong(record.get("일요일_매출_건수"));
        tmzon00SaleCnt = Long.parseLong(record.get("시간대_건수~06_매출_건수"));
        tmzon06SaleCnt = Long.parseLong(record.get("시간대_건수~11_매출_건수"));
        tmzon11SaleCnt = Long.parseLong(record.get("시간대_건수~14_매출_건수"));
        tmzon14SaleCnt = Long.parseLong(record.get("시간대_건수~17_매출_건수"));
        tmzon17SaleCnt = Long.parseLong(record.get("시간대_건수~21_매출_건수"));
        tmzon21SaleCnt = Long.parseLong(record.get("시간대_건수~24_매출_건수"));
        maleSaleCnt = Long.parseLong(record.get("남성_매출_건수"));
        femaleSaleCnt = Long.parseLong(record.get("여성_매출_건수"));
        ageG10SaleCnt = Long.parseLong(record.get("연령대_10_매출_건수"));
        ageG20SaleCnt = Long.parseLong(record.get("연령대_20_매출_건수"));
        ageG30SaleCnt = Long.parseLong(record.get("연령대_30_매출_건수"));
        ageG40SaleCnt = Long.parseLong(record.get("연령대_40_매출_건수"));
        ageG50SaleCnt = Long.parseLong(record.get("연령대_50_매출_건수"));
        ageG60UppSaleCnt = Long.parseLong(record.get("연령대_60_이상_매출_건수"));
    }
}