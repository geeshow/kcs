package kyutae.codetest.kcs.component.loader.dto;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.csv.CSVRecord;

@Getter
@Setter
public class LoaderSalesDto implements LoaderInterface {
    private String stdrYyquCd; // 기준_년분기_코드
    private String seoulCd; // 서울시_코드
    private String seoulCdNm; // 서울시_코드_명
    private String svcIndutyCd; // 서비스_업종_코드
    private String svcIndutyCdNm; // 서비스_업종_코드_명
    private long monthSalesAmt; // 당월_매출_금액
    private int monthSalesCnt; // 당월_매출_건수
    private long weekdaySalesAmt; // 주중_매출_금액
    private long weekendSalesAmt; // 주말_매출_금액
    private long mondaySalesAmt; // 월요일_매출_금액
    private long tuesdaySalesAmt; // 화요일_매출_금액
    private long wednesdaySalesAmt; // 수요일_매출_금액
    private long thursdaySalesAmt; // 목요일_매출_금액
    private long fridaySalesAmt; // 금요일_매출_금액
    private long saturdaySalesAmt; // 토요일_매출_금액
    private long sundaySalesAmt; // 일요일_매출_금액
    private long timeSalesAmt0006; // 시간대_00~06_매출_금액
    private long timeSalesAmt0611; // 시간대_06~11_매출_금액
    private long timeSalesAmt1114; // 시간대_11~14_매출_금액
    private long timeSalesAmt1417; // 시간대_14~17_매출_금액
    private long timeSalesAmt1721; // 시간대_17~21_매출_금액
    private long timeSalesAmt2124; // 시간대_21~24_매출_금액
    private long maleSalesAmt; // 남성_매출_금액
    private long femaleSalesAmt; // 여성_매출_금액
    private long ageGroupSalesAmt10; // 연령대_10_매출_금액
    private long ageGroupSalesAmt20; // 연령대_20_매출_금액
    private long ageGroupSalesAmt30; // 연령대_30_매출_금액
    private long ageGroupSalesAmt40; // 연령대_40_매출_금액
    private long ageGroupSalesAmt50; // 연령대_50_매출_금액
    private long ageGroupSalesAmt60; // 연령대_60_이상_매출_금액
    private int weekdaySalesCnt; // 주중_매출_건수
    private int weekendSalesCnt; // 주말_매출_건수
    private int mondaySalesCnt; // 월요일_매출_건수
    private int tuesdaySalesCnt; // 화요일_매출_건수
    private int wednesdaySalesCnt; // 수요일_매출_건수
    private int thursdaySalesCnt; // 목요일_매출_건수
    private int fridaySalesCnt; // 금요일_매출_건수
    private int saturdaySalesCnt; // 토요일_매출_건수
    private int sundaySalesCnt; // 일요일_매출_건수
    private int timeSalesCnt0006; // 시간대_건수~06_매출_건수
    private int timeSalesCnt0611; // 시간대_건수~11_매출_건수
    private int timeSalesCnt1114; // 시간대_건수~14_매출_건수
    private int timeSalesCnt1417; // 시간대_건수~17_매출_건수
    private int timeSalesCnt1721; // 시간대_건수~21_매출_건수
    private int timeSalesCnt2124; // 시간대_건수~24_매출_건수
    private int maleSalesCnt; // 남성_매출_건수
    private int femaleSalesCnt; // 여성_매출_건수
    private int ageGroupSalesCnt10; // 연령대_10_매출_건수
    private int ageGroupSalesCnt20; // 연령대_20_매출_건수
    private int ageGroupSalesCnt30; // 연령대_30_매출_건수
    private int ageGroupSalesCnt40; // 연령대_40_매출_건수
    private int ageGroupSalesCnt50; // 연령대_50_매출_건수
    private int ageGroupSalesCnt60; // 연령대_60_이상_매출_건수

    @Override
    public void mapFromCsvRecord(CSVRecord record) {
        stdrYyquCd = record.get("기준_년분기_코드");
        seoulCd = record.get("서울시_코드");
        seoulCdNm = record.get("서울시_코드_명");
        svcIndutyCd = record.get("서비스_업종_코드");
        svcIndutyCdNm = record.get("서비스_업종_코드_명");
        monthSalesAmt = Long.parseLong(record.get("당월_매출_금액"));
        monthSalesCnt = Integer.parseInt(record.get("당월_매출_건수"));
        weekdaySalesAmt = Long.parseLong(record.get("주중_매출_금액"));
        weekendSalesAmt = Long.parseLong(record.get("주말_매출_금액"));
        mondaySalesAmt = Long.parseLong(record.get("월요일_매출_금액"));
        tuesdaySalesAmt = Long.parseLong(record.get("화요일_매출_금액"));
        wednesdaySalesAmt = Long.parseLong(record.get("수요일_매출_금액"));
        thursdaySalesAmt = Long.parseLong(record.get("목요일_매출_금액"));
        fridaySalesAmt = Long.parseLong(record.get("금요일_매출_금액"));
        saturdaySalesAmt = Long.parseLong(record.get("토요일_매출_금액"));
        sundaySalesAmt = Long.parseLong(record.get("일요일_매출_금액"));
        timeSalesAmt0006 = Long.parseLong(record.get("시간대_00~06_매출_금액"));
        timeSalesAmt0611 = Long.parseLong(record.get("시간대_06~11_매출_금액"));
        timeSalesAmt1114 = Long.parseLong(record.get("시간대_11~14_매출_금액"));
        timeSalesAmt1417 = Long.parseLong(record.get("시간대_14~17_매출_금액"));
        timeSalesAmt1721 = Long.parseLong(record.get("시간대_17~21_매출_금액"));
        timeSalesAmt2124 = Long.parseLong(record.get("시간대_21~24_매출_금액"));
        maleSalesAmt = Long.parseLong(record.get("남성_매출_금액"));
        femaleSalesAmt = Long.parseLong(record.get("여성_매출_금액"));
        ageGroupSalesAmt10 = Long.parseLong(record.get("연령대_10_매출_금액"));
        ageGroupSalesAmt20 = Long.parseLong(record.get("연령대_20_매출_금액"));
        ageGroupSalesAmt30 = Long.parseLong(record.get("연령대_30_매출_금액"));
        ageGroupSalesAmt40 = Long.parseLong(record.get("연령대_40_매출_금액"));
        ageGroupSalesAmt50 = Long.parseLong(record.get("연령대_50_매출_금액"));
        ageGroupSalesAmt60 = Long.parseLong(record.get("연령대_60_이상_매출_금액"));
        weekdaySalesCnt = Integer.parseInt(record.get("주중_매출_건수"));
        weekendSalesCnt = Integer.parseInt(record.get("주말_매출_건수"));
        mondaySalesCnt = Integer.parseInt(record.get("월요일_매출_건수"));
        tuesdaySalesCnt = Integer.parseInt(record.get("화요일_매출_건수"));
        wednesdaySalesCnt = Integer.parseInt(record.get("수요일_매출_건수"));
        thursdaySalesCnt = Integer.parseInt(record.get("목요일_매출_건수"));
        fridaySalesCnt = Integer.parseInt(record.get("금요일_매출_건수"));
        saturdaySalesCnt = Integer.parseInt(record.get("토요일_매출_건수"));
        sundaySalesCnt = Integer.parseInt(record.get("일요일_매출_건수"));
        timeSalesCnt0006 = Integer.parseInt(record.get("시간대_건수~06_매출_건수"));
        timeSalesCnt0611 = Integer.parseInt(record.get("시간대_건수~11_매출_건수"));
        timeSalesCnt1114 = Integer.parseInt(record.get("시간대_건수~14_매출_건수"));
        timeSalesCnt1417 = Integer.parseInt(record.get("시간대_건수~17_매출_건수"));
        timeSalesCnt1721 = Integer.parseInt(record.get("시간대_건수~21_매출_건수"));
        timeSalesCnt2124 = Integer.parseInt(record.get("시간대_건수~24_매출_건수"));
        maleSalesCnt = Integer.parseInt(record.get("남성_매출_건수"));
        femaleSalesCnt = Integer.parseInt(record.get("여성_매출_건수"));
        ageGroupSalesCnt10 = Integer.parseInt(record.get("연령대_10_매출_건수"));
        ageGroupSalesCnt20 = Integer.parseInt(record.get("연령대_20_매출_건수"));
        ageGroupSalesCnt30 = Integer.parseInt(record.get("연령대_30_매출_건수"));
        ageGroupSalesCnt40 = Integer.parseInt(record.get("연령대_40_매출_건수"));
        ageGroupSalesCnt50 = Integer.parseInt(record.get("연령대_50_매출_건수"));
        ageGroupSalesCnt60 = Integer.parseInt(record.get("연령대_60_이상_매출_건수"));
    }
}