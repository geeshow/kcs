package kyutae.codetest.kcs.service;

import kyutae.codetest.kcs.component.loader.dto.LoaderSalesDto;
import kyutae.codetest.kcs.component.loader.dto.LoaderTrdarDto;
import kyutae.codetest.kcs.entity.*;
import kyutae.codetest.kcs.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ImportSalesService {
    private final TrdarSeMstRepository trdarSeMstRepository;
    private final TrdarMstRepository trdarMstRepository;
    private final SvcIndutyMstRepository svcIndutyMstRepository;
    private final TrdarSalesDtlRepository trdarSalesDtlRepository;

    public ImportSalesService(
            SvcIndutyMstRepository svcIndutyMstRepository,
            TrdarSalesDtlRepository trdarSalesDtlRepository,
            TrdarSeMstRepository trdarSeMstRepository,
            TrdarMstRepository trdarMstRepository
    ) {
        this.svcIndutyMstRepository = svcIndutyMstRepository;
        this.trdarSalesDtlRepository = trdarSalesDtlRepository;
        this.trdarSeMstRepository = trdarSeMstRepository;
        this.trdarMstRepository = trdarMstRepository;
    }

    @Transactional
    public void importData(List<LoaderSalesDto> allRecords) {
        try {
            Map<String, TrdarMst> trdarMap = new HashMap<>();
            Map<String, TrdarSeMst> trdarSeMap = new HashMap<>();
            Map<String, SvcIndutyMst> svcIndutyMap = new HashMap<>();

            long allCount = allRecords.size();
            long progressCount = 0;
            for (LoaderSalesDto record : allRecords) {
                processTrdarSeMst(record, trdarSeMap);
                processTrdarMst(record, trdarMap, trdarSeMap);
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
        String progressBar = "[" + String.format("%02d", progress) + "%]" + "-".repeat(dashes) + " ".repeat(spaces) + " " + progressCount + "/" + allCount;
        System.out.print("\r" + progressBar);
    }

    private void processTrdarSeMst(LoaderSalesDto record, Map<String, TrdarSeMst> trdarSeMap) {
        String trdarSeCd = record.getTrdarSeCd(); // 상권_구분_코드
        if (!trdarSeMap.containsKey(trdarSeCd)) {
            TrdarSeMst trdarSeMst = TrdarSeMst.builder()
                    .trdarSeCd(trdarSeCd)
                    .trdarSeCdNm(record.getTrdarSeCdNm())// 상권_구분_코드_명
                    .build();

            trdarSeMap.put(trdarSeCd, trdarSeMstRepository.save(trdarSeMst));
        }
    }

    private void processTrdarMst(LoaderSalesDto record, Map<String, TrdarMst> trdarMap, Map<String, TrdarSeMst> trdarSeMap) {
        String trdarCd = record.getTrdarCd(); // 상권_코드
        if (!trdarMap.containsKey(trdarCd)) {
            TrdarMst trdarMst = TrdarMst.builder()
                    .trdarCd(trdarCd) // 상권_코드
                    .trdarCdNm(record.getTrdarCdNm()) // 상권_코드_명
                    .trdarSe(trdarSeMap.get(record.getTrdarSeCd())) // 상권_구분_코드
                    .build();

            trdarMap.put(trdarCd, trdarMstRepository.save(trdarMst));
        }
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
                .stdrYyquCd(record.getStdrYyquCd())
                .trdar(trdarMap.get(record.getTrdarCd()))
                .svcInduty(svcIndutyMap.get(record.getSvcIndutyCd())) // 서비스_업종_코드
                .mthSaleAmt(record.getMthSaleAmt())
                .mthSaleCnt(record.getMthSaleCnt())
                .weekdayAvgSaleAmt(record.getWeekdayAvgSaleAmt())
                .holidayAvgSaleAmt(record.getHolidayAvgSaleAmt())
                .monSaleAmt(record.getMonSaleAmt())
                .tueSaleAmt(record.getTueSaleAmt())
                .wedSaleAmt(record.getWedSaleAmt())
                .thuSaleAmt(record.getThuSaleAmt())
                .friSaleAmt(record.getFriSaleAmt())
                .satSaleAmt(record.getSatSaleAmt())
                .sunSaleAmt(record.getSunSaleAmt())
                .tmzon00SaleAmt(record.getTmzon00SaleAmt())
                .tmzon06SaleAmt(record.getTmzon06SaleAmt())
                .tmzon11SaleAmt(record.getTmzon11SaleAmt())
                .tmzon14SaleAmt(record.getTmzon14SaleAmt())
                .tmzon17SaleAmt(record.getTmzon17SaleAmt())
                .tmzon21SaleAmt(record.getTmzon21SaleAmt())
                .maleSaleAmt(record.getMaleSaleAmt())
                .femaleSaleAmt(record.getFemaleSaleAmt())
                .ageG10SaleAmt(record.getAgeG10SaleAmt())
                .ageG20SaleAmt(record.getAgeG20SaleAmt())
                .ageG30SaleAmt(record.getAgeG30SaleAmt())
                .ageG40SaleAmt(record.getAgeG40SaleAmt())
                .ageG50SaleAmt(record.getAgeG50SaleAmt())
                .ageG60UppSaleAmt(record.getAgeG60UppSaleAmt())
                .weekdayAvgSaleCnt(record.getWeekdayAvgSaleCnt())
                .holidayAvgSaleCnt(record.getHolidayAvgSaleCnt())
                .monSaleCnt(record.getMonSaleCnt())
                .tueSaleCnt(record.getTueSaleCnt())
                .wedSaleCnt(record.getWedSaleCnt())
                .thuSaleCnt(record.getThuSaleCnt())
                .friSaleCnt(record.getFriSaleCnt())
                .satSaleCnt(record.getSatSaleCnt())
                .sunSaleCnt(record.getSunSaleCnt())
                .tmzon00SaleCnt(record.getTmzon00SaleCnt())
                .tmzon06SaleCnt(record.getTmzon06SaleCnt())
                .tmzon11SaleCnt(record.getTmzon11SaleCnt())
                .tmzon14SaleCnt(record.getTmzon14SaleCnt())
                .tmzon17SaleCnt(record.getTmzon17SaleCnt())
                .tmzon21SaleCnt(record.getTmzon21SaleCnt())
                .maleSaleCnt(record.getMaleSaleCnt())
                .femaleSaleCnt(record.getFemaleSaleCnt())
                .ageG10SaleCnt(record.getAgeG10SaleCnt())
                .ageG20SaleCnt(record.getAgeG20SaleCnt())
                .ageG30SaleCnt(record.getAgeG30SaleCnt())
                .ageG40SaleCnt(record.getAgeG40SaleCnt())
                .ageG50SaleCnt(record.getAgeG50SaleCnt())
                .ageG60UppSaleCnt(record.getAgeG60UppSaleCnt())
                .build();

        trdarSalesDtlRepository.save(trdarSalesDtl);
    }
}