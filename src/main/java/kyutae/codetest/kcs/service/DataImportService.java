package kyutae.codetest.kcs.service;

import kyutae.codetest.kcs.entity.SvcIndutyMst;
import kyutae.codetest.kcs.entity.TrdarMst;
import kyutae.codetest.kcs.entity.TrdarSeMst;
import kyutae.codetest.kcs.entity.TrdarStorDtl;
import kyutae.codetest.kcs.repository.SvcIndutyMstRepository;
import kyutae.codetest.kcs.repository.TrdarMstRepository;
import kyutae.codetest.kcs.repository.TrdarSeMstRepository;
import kyutae.codetest.kcs.repository.TrdarStorDtlRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataImportService {

    private final SvcIndutyMstRepository svcIndutyMstRepository;
    private final TrdarMstRepository trdarMstRepository;
    private final TrdarSeMstRepository trdarSeMstRepository;
    private final TrdarStorDtlRepository trdarStorDtlRepository;

    public DataImportService(SvcIndutyMstRepository svcIndutyMstRepository, TrdarMstRepository trdarMstRepository, TrdarSeMstRepository trdarSeMstRepository, TrdarStorDtlRepository trdarStorDtlRepository) {
        this.svcIndutyMstRepository = svcIndutyMstRepository;
        this.trdarMstRepository = trdarMstRepository;
        this.trdarSeMstRepository = trdarSeMstRepository;
        this.trdarStorDtlRepository = trdarStorDtlRepository;
    }

    @Transactional
    public void importData(List<Map<String, String>> allRecords) {
        try {
            Map<String, TrdarSeMst> trdarSeMap = new HashMap<>();
            Map<String, TrdarMst> trdarMap = new HashMap<>();
            Map<String, SvcIndutyMst> svcIndutyMap = new HashMap<>();

            long allCount = allRecords.size();
            long progressCount = 0;
            for (Map<String, String> record : allRecords) {
                processTrdarSeMst(record, trdarSeMap);
                processTrdarMst(record, trdarMap, trdarSeMap);
                processSvcIndutyMst(record, svcIndutyMap);
                processTrdarStorDtl(record, trdarMap, svcIndutyMap);

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

    private void processTrdarSeMst(Map<String, String> record, Map<String, TrdarSeMst> trdarSeMap) {
        String trdarSeCd = record.get("상권_구분_코드");
        if (!trdarSeMap.containsKey(trdarSeCd)) {
            TrdarSeMst trdarSeMst = TrdarSeMst.builder()
                .trdarSeCd(trdarSeCd)
                .trdarSeCdNm(record.get("상권_구분_코드_명"))
                .build();

            trdarSeMap.put(trdarSeCd, trdarSeMstRepository.save(trdarSeMst));
        }
    }

    private void processTrdarMst(Map<String, String> record, Map<String, TrdarMst> trdarMap, Map<String, TrdarSeMst> trdarSeMap) {
        String trdarCd = record.get("상권_코드");
        if (!trdarMap.containsKey(trdarCd)) {
            TrdarMst trdarMst = TrdarMst.builder()
                .trdarCd(trdarCd)
                .trdarCdNm(record.get("상권_코드_명"))
                .trdarSe(trdarSeMap.get(record.get("상권_구분_코드")))
                .build();

            trdarMap.put(trdarCd, trdarMstRepository.save(trdarMst));
        }
    }

    private void processSvcIndutyMst(Map<String, String> record, Map<String, SvcIndutyMst> svcIndutyMap) {
        String svcIndutyCd = record.get("서비스_업종_코드");
        if (!svcIndutyMap.containsKey(svcIndutyCd)) {
            SvcIndutyMst svcIndutyMst = SvcIndutyMst.builder()
                .svcIndutyCd(svcIndutyCd)
                .svcIndutyCdNm(record.get("서비스_업종_코드_명"))
                .build();

            svcIndutyMap.put(svcIndutyCd, svcIndutyMstRepository.save(svcIndutyMst));
        }
    }

    private void processTrdarStorDtl(Map<String, String> record, Map<String, TrdarMst> trdarMap, Map<String, SvcIndutyMst> svcIndutyMap) {
        TrdarStorDtl trdarStorDtl = TrdarStorDtl.builder()
            .stdrYyquCd(record.get("기준_년분기_코드"))
            .trdar(trdarMap.get(record.get("상권_코드")))
            .svcInduty(svcIndutyMap.get(record.get("서비스_업종_코드")))
            .storCo(Integer.parseInt(record.get("점포_수")))
            .similrIndutyStorCo(Integer.parseInt(record.get("유사_업종_점포_수")))
            .opbizRt(Integer.parseInt(record.get("개업_율")))
            .opbizStorCo(Integer.parseInt(record.get("개업_점포_수")))
            .clsbizRt(Integer.parseInt(record.get("폐업_률")))
            .clsbizStorCo(Integer.parseInt(record.get("폐업_점포_수")))
            .frcStorCo(Integer.parseInt(record.get("프랜차이즈_점포_수")))
            .build();

        trdarStorDtlRepository.save(trdarStorDtl);
    }
}