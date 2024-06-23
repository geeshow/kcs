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

    @Column(name = "STDR_YYQU_CD", length = 5)
    private String stdrYyquCd;

    @ManyToOne
    @JoinColumn(name = "TRDAR_CD")
    private TrdarMst trdar;

    @ManyToOne
    @JoinColumn(name = "SVC_INDUTY_CD")
    private SvcIndutyMst svcInduty;

    @Column(name = "MTH_SALE_AMT")
    private Long mthSaleAmt;

    @Column(name = "MTH_SALE_CNT")
    private Long mthSaleCnt;

    @Column(name = "WEEKDAY_AVG_SALE_AMT")
    private Long weekdayAvgSaleAmt;

    @Column(name = "HOLIDAY_AVG_SALE_AMT")
    private Long holidayAvgSaleAmt;

    @Column(name = "MON_SALE_AMT")
    private Long monSaleAmt;

    @Column(name = "TUE_SALE_AMT")
    private Long tueSaleAmt;

    @Column(name = "WED_SALE_AMT")
    private Long wedSaleAmt;

    @Column(name = "THU_SALE_AMT")
    private Long thuSaleAmt;

    @Column(name = "FRI_SALE_AMT")
    private Long friSaleAmt;

    @Column(name = "SAT_SALE_AMT")
    private Long satSaleAmt;

    @Column(name = "SUN_SALE_AMT")
    private Long sunSaleAmt;

    @Column(name = "TMZON_00_SALE_AMT")
    private Long tmzon00SaleAmt;

    @Column(name = "TMZON_06_SALE_AMT")
    private Long tmzon06SaleAmt;

    @Column(name = "TMZON_11_SALE_AMT")
    private Long tmzon11SaleAmt;

    @Column(name = "TMZON_14_SALE_AMT")
    private Long tmzon14SaleAmt;

    @Column(name = "TMZON_17_SALE_AMT")
    private Long tmzon17SaleAmt;

    @Column(name = "TMZON_21_SALE_AMT")
    private Long tmzon21SaleAmt;

    @Column(name = "MALE_SALE_AMT")
    private Long maleSaleAmt;

    @Column(name = "FEMALE_SALE_AMT")
    private Long femaleSaleAmt;

    @Column(name = "AGE_G10_SALE_AMT")
    private Long ageG10SaleAmt;

    @Column(name = "AGE_G20_SALE_AMT")
    private Long ageG20SaleAmt;

    @Column(name = "AGE_G30_SALE_AMT")
    private Long ageG30SaleAmt;

    @Column(name = "AGE_G40_SALE_AMT")
    private Long ageG40SaleAmt;

    @Column(name = "AGE_G50_SALE_AMT")
    private Long ageG50SaleAmt;

    @Column(name = "AGE_G60_UPP_SALE_AMT")
    private Long ageG60UppSaleAmt;

    @Column(name = "WEEKDAY_AVG_SALE_CNT")
    private Long weekdayAvgSaleCnt;

    @Column(name = "HOLIDAY_AVG_SALE_CNT")
    private Long holidayAvgSaleCnt;

    @Column(name = "MON_SALE_CNT")
    private Long monSaleCnt;

    @Column(name = "TUE_SALE_CNT")
    private Long tueSaleCnt;

    @Column(name = "WED_SALE_CNT")
    private Long wedSaleCnt;

    @Column(name = "THU_SALE_CNT")
    private Long thuSaleCnt;

    @Column(name = "FRI_SALE_CNT")
    private Long friSaleCnt;

    @Column(name = "SAT_SALE_CNT")
    private Long satSaleCnt;

    @Column(name = "SUN_SALE_CNT")
    private Long sunSaleCnt;

    @Column(name = "TMZON_00_SALE_CNT")
    private Long tmzon00SaleCnt;

    @Column(name = "TMZON_06_SALE_CNT")
    private Long tmzon06SaleCnt;

    @Column(name = "TMZON_11_SALE_CNT")
    private Long tmzon11SaleCnt;

    @Column(name = "TMZON_14_SALE_CNT")
    private Long tmzon14SaleCnt;

    @Column(name = "TMZON_17_SALE_CNT")
    private Long tmzon17SaleCnt;

    @Column(name = "TMZON_21_SALE_CNT")
    private Long tmzon21SaleCnt;

    @Column(name = "MALE_SALE_CNT")
    private Long maleSaleCnt;

    @Column(name = "FEMALE_SALE_CNT")
    private Long femaleSaleCnt;

    @Column(name = "AGE_G10_SALE_CNT")
    private Long ageG10SaleCnt;

    @Column(name = "AGE_G20_SALE_CNT")
    private Long ageG20SaleCnt;

    @Column(name = "AGE_G30_SALE_CNT")
    private Long ageG30SaleCnt;

    @Column(name = "AGE_G40_SALE_CNT")
    private Long ageG40SaleCnt;

    @Column(name = "AGE_G50_SALE_CNT")
    private Long ageG50SaleCnt;

    @Column(name = "AGE_G60_UPP_SALE_CNT")
    private Long ageG60UppSaleCnt;
}