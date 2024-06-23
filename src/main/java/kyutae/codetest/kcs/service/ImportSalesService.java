package kyutae.codetest.kcs.service;

import kyutae.codetest.kcs.component.loader.dto.LoaderSalesDto;
import kyutae.codetest.kcs.entity.*;
import kyutae.codetest.kcs.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ImportSalesService {

    private final SvcIndutyMstRepository svcIndutyMstRepository;
    private final TrdarSalesDtlRepository trdarSalesDtlRepository;

    public ImportSalesService(SvcIndutyMstRepository svcIndutyMstRepository, TrdarSalesDtlRepository trdarSalesDtlRepository) {
        this.svcIndutyMstRepository = svcIndutyMstRepository;
        this.trdarSalesDtlRepository = trdarSalesDtlRepository;
    }

    @Transactional
    public void importData(List<LoaderSalesDto> allRecords) {
        try {
            Map<String, TrdarMst> trdarMap = new HashMap<>();
            Map<String, SvcIndutyMst> svcIndutyMap = new HashMap<>();

            long allCount = allRecords.size();
            long progressCount = 0;
            for (LoaderSalesDto record : allRecords) {
                processSvcIndutyMst(record, svcIndutyMap);
                processTrdarSalesDtl(record, trdarMap, svcIndutyMap);

                ++progressCount;
                printProgress(progressCount, allCount);
            }

            System.out.println("Data import completed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error occurred during data import: " + e.getMessage());
        }
    }

    private void printProgress(long progressCount, long allCount) {
        int progress = (int) ((progressCount / (double) allCount) * 100);

        int dashes = progress / 2;
        int spaces = 50 - dashes;
        String progressBar = "[" + String.format("%02d", progress) + "%]" + "-".repeat(dashes) + " ".repeat(spaces);
        System.out.print("\r" + progressBar);
    }


    private void processSvcIndutyMst(LoaderSalesDto record, Map<String, SvcIndutyMst> svcIndutyMap) {
        String svcIndutyCd = record.getSvcIndutyCd(); // 서비스_업종_코드
        if (!svcIndutyMap.containsKey(svcIndutyCd)) {
            SvcIndutyMst svcIndutyMst = SvcIndutyMst.builder()
                .svcIndutyCd(svcIndutyCd)
                .svcIndutyCdNm(record.getSvcIndutyCdNm()) // 서비스_업종_코드_명
                .build();

            svcIndutyMap.put(svcIndutyCd, svcIndutyMstRepository.save(svcIndutyMst));
        }
    }

    private void processTrdarSalesDtl(LoaderSalesDto record, Map<String, TrdarMst> trdarMap, Map<String, SvcIndutyMst> svcIndutyMap) {
        TrdarSalesDtl trdarSalesDtl = TrdarSalesDtl.builder()
            .stdrYyquCd(record.getStdrYyquCd()) // 기준_년분기_코드
            .seoulCd(record.getSeoulCd()) // 서울시_코드
            .seoulCdNm(record.getSeoulCdNm()) // 서울시_코드_명
            .svcInduty(svcIndutyMap.get(record.getSvcIndutyCd())) // 서비스_업종_코드
            .monthSalesAmt(record.getMonthSalesAmt()) // 당월_매출_금액
            .monthSalesCnt(record.getMonthSalesCnt()) // 당월_매출_건수
            .weekdaySalesAmt(record.getWeekdaySalesAmt()) // 주중_매출_금액
            .weekendSalesAmt(record.getWeekendSalesAmt()) // 주말_매출_금액
            .mondaySalesAmt(record.getMondaySalesAmt()) // 월요일_매출_금액
            .tuesdaySalesAmt(record.getTuesdaySalesAmt()) // 화요일_매출_금액
            .wednesdaySalesAmt(record.getWednesdaySalesAmt()) // 수요일_매출_금액
            .thursdaySalesAmt(record.getThursdaySalesAmt()) // 목요일_매출_금액
            .fridaySalesAmt(record.getFridaySalesAmt()) // 금요일_매출_금액
            .saturdaySalesAmt(record.getSaturdaySalesAmt()) // 토요일_매출_금액
            .sundaySalesAmt(record.getSundaySalesAmt()) // 일요일_매출_금액
            .timeSalesAmt0006(record.getTimeSalesAmt0006()) // 시간대_00~06_매출_금액
            .timeSalesAmt0611(record.getTimeSalesAmt0611()) // 시간대_06~11_매출_금액
            .timeSalesAmt1114(record.getTimeSalesAmt1114()) // 시간대_11~14_매출_금액
            .timeSalesAmt1417(record.getTimeSalesAmt1417()) // 시간대_14~17_매출_금액
            .timeSalesAmt1721(record.getTimeSalesAmt1721()) // 시간대_17~21_매출_금액
            .timeSalesAmt2124(record.getTimeSalesAmt2124()) // 시간대_21~24_매출_
            .maleSalesAmt(record.getMaleSalesAmt()) // 남성_매출_금액
            .femaleSalesAmt(record.getFemaleSalesAmt()) // 여성_매출_금액
            .ageGroupSalesAmt10(record.getAgeGroupSalesAmt10()) // 연령대_10_매출_금액
            .ageGroupSalesAmt20(record.getAgeGroupSalesAmt20()) // 연령대_20_매출_금액
            .ageGroupSalesAmt30(record.getAgeGroupSalesAmt30()) // 연령대_30_매출_금액
            .ageGroupSalesAmt40(record.getAgeGroupSalesAmt40()) // 연령대_40_매출_금액
            .ageGroupSalesAmt50(record.getAgeGroupSalesAmt50()) // 연령대_50_매출_금액
            .ageGroupSalesAmt60(record.getAgeGroupSalesAmt60()) // 연령대_60_이상_매출_금액
            .weekdaySalesCnt(record.getWeekdaySalesCnt()) // 주중_매출_건수
            .weekendSalesCnt(record.getWeekendSalesCnt()) // 주말_매출_건수
            .mondaySalesCnt(record.getMondaySalesCnt()) // 월요일_매출_건수
            .tuesdaySalesCnt(record.getTuesdaySalesCnt()) // 화요일_매출_건수
            .wednesdaySalesCnt(record.getWednesdaySalesCnt()) // 수요일_매출_건수
            .thursdaySalesCnt(record.getThursdaySalesCnt()) // 목요일_매출_건수
            .fridaySalesCnt(record.getFridaySalesCnt()) // 금요일_매출_건수
            .saturdaySalesCnt(record.getSaturdaySalesCnt()) // 토요일_매출_건수
            .sundaySalesCnt(record.getSundaySalesCnt()) // 일요일_매출_건수
            .timeSalesCnt0006(record.getTimeSalesCnt0006()) // 시간대_건수~06_매출_건수
            .timeSalesCnt0611(record.getTimeSalesCnt0611()) // 시간대_건수~11_매출_건수
            .timeSalesCnt1114(record.getTimeSalesCnt1114()) // 시간대_건수~14_매출_건수
            .timeSalesCnt1417(record.getTimeSalesCnt1417()) // 시간대_건수~17_매출_건수
            .timeSalesCnt1721(record.getTimeSalesCnt1721()) // 시간대_건수~21_매출_건수
            .timeSalesCnt2124(record.getTimeSalesCnt2124()) // 시간대_건수~24_매출_
            .maleSalesCnt(record.getMaleSalesCnt()) // 남성_매출_건수
            .femaleSalesCnt(record.getFemaleSalesCnt()) // 여성_매출_건수
            .ageGroupSalesCnt10(record.getAgeGroupSalesCnt10()) // 연령대_10_매출_건수
            .ageGroupSalesCnt20(record.getAgeGroupSalesCnt20()) // 연령대_20_매출_건수
            .ageGroupSalesCnt30(record.getAgeGroupSalesCnt30()) // 연령대_30_매출_건수
            .ageGroupSalesCnt40(record.getAgeGroupSalesCnt40()) // 연령대_40_매출_건수
            .ageGroupSalesCnt50(record.getAgeGroupSalesCnt50()) // 연령대_50_매출_건수
            .ageGroupSalesCnt60(record.getAgeGroupSalesCnt60()) // 연령대_60_이상_매출_건수
            .build();


        trdarSalesDtlRepository.save(trdarSalesDtl);
    }
}