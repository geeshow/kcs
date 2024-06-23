package kyutae.codetest.kcs.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TRDAR_SALES_DTL")
public class TrdarSalesDtl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "STDR_YYQU_CD")
    private String stdrYyquCd; // 기준_년분기_코드

    @Column(name = "SEOUL_CD")
    private String seoulCd; // 서울시_코드

    @Column(name = "SEOUL_CD_NM")
    private String seoulCdNm; // 서울시_코드_명

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SVC_INDUTY_CD")
    private SvcIndutyMst svcInduty; // 서비스_업종

    @Column(name = "MONTH_SALES_AMT")
    private long monthSalesAmt; // 당월_매출_금액

    @Column(name = "MONTH_SALES_CNT")
    private int monthSalesCnt; // 당월_매출_건수

    @Column(name = "WEEKDAY_SALES_AMT")
    private long weekdaySalesAmt; // 주중_매출_금액

    @Column(name = "WEEKEND_SALES_AMT")
    private long weekendSalesAmt; // 주말_매출_금액

    @Column(name = "MONDAY_SALES_AMT")
    private long mondaySalesAmt; // 월요일_매출_금액

    @Column(name = "TUESDAY_SALES_AMT")
    private long tuesdaySalesAmt; // 화요일_매출_금액

    @Column(name = "WEDNESDAY_SALES_AMT")
    private long wednesdaySalesAmt; // 수요일_매출_금액

    @Column(name = "THURSDAY_SALES_AMT")
    private long thursdaySalesAmt; // 목요일_매출_금액

    @Column(name = "FRIDAY_SALES_AMT")
    private long fridaySalesAmt; // 금요일_매출_금액

    @Column(name = "SATURDAY_SALES_AMT")
    private long saturdaySalesAmt; // 토요일_매출_금액

    @Column(name = "SUNDAY_SALES_AMT")
    private long sundaySalesAmt; // 일요일_매출_금액

    @Column(name = "TIME_SALES_AMT_0006")
    private long timeSalesAmt0006; // 시간대_00~06_매출_금액

    @Column(name = "TIME_SALES_AMT_0611")
    private long timeSalesAmt0611; // 시간대_06~11_매출_금액

    @Column(name = "TIME_SALES_AMT_1114")
    private long timeSalesAmt1114; // 시간대_11~14_매출_금액

    @Column(name = "TIME_SALES_AMT_1417")
    private long timeSalesAmt1417; // 시간대_14~17_매출_금액

    @Column(name = "TIME_SALES_AMT_1721")
    private long timeSalesAmt1721; // 시간대_17~21_매출_금액

    @Column(name = "TIME_SALES_AMT_2124")
    private long timeSalesAmt2124; // 시간대_21~24_매출_금액

    @Column(name = "MALE_SALES_AMT")
    private long maleSalesAmt; // 남성_매출_금액

    @Column(name = "FEMALE_SALES_AMT")
    private long femaleSalesAmt; // 여성_매출_금액

    @Column(name = "AGE_GROUP_SALES_AMT_10")
    private long ageGroupSalesAmt10; // 연령대_10_매출_금액

    @Column(name = "AGE_GROUP_SALES_AMT_20")
    private long ageGroupSalesAmt20; // 연령대_20_매출_금액

    @Column(name = "AGE_GROUP_SALES_AMT_30")
    private long ageGroupSalesAmt30; // 연령대_30_매출_금액

    @Column(name = "AGE_GROUP_SALES_AMT_40")
    private long ageGroupSalesAmt40; // 연령대_40_매출_금액

    @Column(name = "AGE_GROUP_SALES_AMT_50")
    private long ageGroupSalesAmt50; // 연령대_50_매출_금액

    @Column(name = "AGE_GROUP_SALES_AMT_60")
    private long ageGroupSalesAmt60; // 연령대_60_이상_매출_금액

    @Column(name = "WEEKDAY_SALES_CNT")
    private int weekdaySalesCnt; // 주중_매출_건수

    @Column(name = "WEEKEND_SALES_CNT")
    private int weekendSalesCnt; // 주말_매출_건수

    @Column(name = "MONDAY_SALES_CNT")
    private int mondaySalesCnt; // 월요일_매출_건수

    @Column(name = "TUESDAY_SALES_CNT")
    private int tuesdaySalesCnt; // 화요일_매출_건수

    @Column(name = "WEDNESDAY_SALES_CNT")
    private int wednesdaySalesCnt; // 수요일_매출_건수

    @Column(name = "THURSDAY_SALES_CNT")
    private int thursdaySalesCnt; // 목요일_매출_건수

    @Column(name = "FRIDAY_SALES_CNT")
    private int fridaySalesCnt; // 금요일_매출_건수

    @Column(name = "SATURDAY_SALES_CNT")
    private int saturdaySalesCnt; // 토요일_매출_건수

    @Column(name = "SUNDAY_SALES_CNT")
    private int sundaySalesCnt; // 일요일_매출_건수

    @Column(name = "TIME_SALES_CNT_0006")
    private int timeSalesCnt0006; // 시간대_건수~06_매출_건수

    @Column(name = "TIME_SALES_CNT_0611")
    private int timeSalesCnt0611; // 시간대_건수~11_매출_건수

    @Column(name = "TIME_SALES_CNT_1114")
    private int timeSalesCnt1114; // 시간대_건수~14_매출_건수

    @Column(name = "TIME_SALES_CNT_1417")
    private int timeSalesCnt1417; // 시간대_건수~17_매출_건수

    @Column(name = "TIME_SALES_CNT_1721")
    private int timeSalesCnt1721; // 시간대_건수~21_매출_건수

    @Column(name = "TIME_SALES_CNT_2124")
    private int timeSalesCnt2124; // 시간대_건수~24_매출_건수

    @Column(name = "MALE_SALES_CNT")
    private int maleSalesCnt; // 남성_매출_건수

    @Column(name = "FEMALE_SALES_CNT")
    private int femaleSalesCnt; // 여성_매출_건수

    @Column(name = "AGE_GROUP_SALES_CNT_10")
    private int ageGroupSalesCnt10; // 연령대_10_매출_건수

    @Column(name = "AGE_GROUP_SALES_CNT_20")
    private int ageGroupSalesCnt20; // 연령대_20_매출_건수

    @Column(name = "AGE_GROUP_SALES_CNT_30")
    private int ageGroupSalesCnt30; // 연령대_30_매출_건수

    @Column(name = "AGE_GROUP_SALES_CNT_40")
    private int ageGroupSalesCnt40; // 연령대_40_매출_건수

    @Column(name = "AGE_GROUP_SALES_CNT_50")
    private int ageGroupSalesCnt50; // 연령대_50_매출_건수

    @Column(name = "AGE_GROUP_SALES_CNT_60")
    private int ageGroupSalesCnt60; // 연령대_60_이상_매출_건수
}