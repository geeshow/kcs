package kyutae.codetest.kcs.repository.querydsl;

import jakarta.persistence.EntityManager;
import kyutae.codetest.kcs.config.QueryDslConfig;
import kyutae.codetest.kcs.entity.SvcIndutyMst;
import kyutae.codetest.kcs.entity.TrdarMst;
import kyutae.codetest.kcs.entity.TrdarSeMst;
import kyutae.codetest.kcs.entity.TrdarStorDtl;
import kyutae.codetest.kcs.repository.querydsl.dto.SvcIndutyDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@Import({QueryDslConfig.class, TrdarStorDtlQueryRepository.class})
class TrdarStorDtlQueryRepositoryTest {
    @Autowired
    private TrdarStorDtlQueryRepository trdarStorDtlQueryRepository;

    @Autowired
    private EntityManager entityManager;

    private TrdarStorDtl createTrdarStorDtl(String stdrYyquCd, TrdarMst trdarMst, SvcIndutyMst svcIndutyMst, int opbizRt, int clsbizRt, int storCo) {
        return TrdarStorDtl.builder()
                .stdrYyquCd(stdrYyquCd)
                .trdar(trdarMst)
                .svcInduty(svcIndutyMst)
                .opbizRt(opbizRt)
                .clsbizRt(clsbizRt)
                .storCo(storCo)
                .build();
    }

    @Test
    void findMaxOpbizRtByStdrYyquCdAndTrdarCd_shouldReturnSvcIndutyDto() {
        // given
        String stdrYyquCd = "20231";
        String trdarCd = "3001491";

        // 테스트 데이터 준비
        TrdarSeMst trdarSeMst = new TrdarSeMst("A", "골목상권");
        TrdarMst trdarMst = new TrdarMst(trdarCd, "상권명", trdarSeMst);
        entityManager.persist(trdarSeMst);
        entityManager.persist(trdarMst);

        SvcIndutyMst svcIndutyMst1 = new SvcIndutyMst("CS100001", "한식음식점");
        SvcIndutyMst svcIndutyMst2 = new SvcIndutyMst("CS100002", "중식음식점");
        entityManager.persist(svcIndutyMst1);
        entityManager.persist(svcIndutyMst2);

        TrdarStorDtl trdarStorDtl1 = createTrdarStorDtl(stdrYyquCd, trdarMst, svcIndutyMst1, 80, 20, 50);
        TrdarStorDtl trdarStorDtl2 = createTrdarStorDtl(stdrYyquCd, trdarMst, svcIndutyMst2, 70, 30, 30);
        entityManager.persist(trdarStorDtl1);
        entityManager.persist(trdarStorDtl2);

        // when
        SvcIndutyDto result = trdarStorDtlQueryRepository.findMaxOpbizRtByStdrYyquCdAndTrdarCd(stdrYyquCd, trdarCd);

        // then
        assertThat(result).isNotNull();
        assertThat(result.getSvcIndutyCd()).isEqualTo("CS100001");
        assertThat(result.getSvcIndutyNm()).isEqualTo("한식음식점");
    }

    @Test
    void findMaxClsbizRtByStdrYyquCdAndTrdarCd_shouldReturnSvcIndutyDto() {
        // given
        String stdrYyquCd = "20231";
        String trdarCd = "3001491";

        // 테스트 데이터 준비
        TrdarSeMst trdarSeMst = new TrdarSeMst("A", "골목상권");
        TrdarMst trdarMst = new TrdarMst(trdarCd, "상권명", trdarSeMst);
        entityManager.persist(trdarSeMst);
        entityManager.persist(trdarMst);

        SvcIndutyMst svcIndutyMst1 = new SvcIndutyMst("CS100001", "한식음식점");
        SvcIndutyMst svcIndutyMst2 = new SvcIndutyMst("CS100002", "중식음식점");
        SvcIndutyMst svcIndutyMst3 = new SvcIndutyMst("CS100003", "일식음식점");
        entityManager.persist(svcIndutyMst1);
        entityManager.persist(svcIndutyMst2);
        entityManager.persist(svcIndutyMst3);

        TrdarStorDtl trdarStorDtl1 = createTrdarStorDtl(stdrYyquCd, trdarMst, svcIndutyMst1, 80, 50, 50);
        TrdarStorDtl trdarStorDtl2 = createTrdarStorDtl(stdrYyquCd, trdarMst, svcIndutyMst2, 70, 30, 30);
        TrdarStorDtl trdarStorDtl3 = createTrdarStorDtl(stdrYyquCd, trdarMst, svcIndutyMst3, 60, 90, 90);
        entityManager.persist(trdarStorDtl1);
        entityManager.persist(trdarStorDtl2);
        entityManager.persist(trdarStorDtl3);

        // when
        SvcIndutyDto result = trdarStorDtlQueryRepository.findMaxClsbizRtByStdrYyquCdAndTrdarCd(stdrYyquCd, trdarCd);

        // then
        assertThat(result).isNotNull();
        assertThat(result.getSvcIndutyCd()).isEqualTo("CS100003");
        assertThat(result.getSvcIndutyNm()).isEqualTo("일식음식점");
    }

    @Test
    void findTopStorCoByStdrYyquCdAndTrdarCd_shouldReturnTopSvcIndutyDto() {
        // given
        String stdrYyquCd = "20231";
        String trdarCd = "3001491";
        int topN = 2;

        // 테스트 데이터 준비
        TrdarSeMst trdarSeMst = new TrdarSeMst("A", "골목상권");
        TrdarMst trdarMst = new TrdarMst(trdarCd, "상권명", trdarSeMst);
        entityManager.persist(trdarSeMst);
        entityManager.persist(trdarMst);

        SvcIndutyMst svcIndutyMst1 = new SvcIndutyMst("CS100001", "한식음식점");
        SvcIndutyMst svcIndutyMst2 = new SvcIndutyMst("CS100002", "중식음식점");
        SvcIndutyMst svcIndutyMst3 = new SvcIndutyMst("CS100003", "일식음식점");
        entityManager.persist(svcIndutyMst1);
        entityManager.persist(svcIndutyMst2);
        entityManager.persist(svcIndutyMst3);

        TrdarStorDtl trdarStorDtl1 = createTrdarStorDtl(stdrYyquCd, trdarMst, svcIndutyMst1, 100, 20, 50);
        TrdarStorDtl trdarStorDtl2 = createTrdarStorDtl(stdrYyquCd, trdarMst, svcIndutyMst2, 80, 30, 30);
        TrdarStorDtl trdarStorDtl3 = createTrdarStorDtl(stdrYyquCd, trdarMst, svcIndutyMst3, 60, 40, 90);
        entityManager.persist(trdarStorDtl1);
        entityManager.persist(trdarStorDtl2);
        entityManager.persist(trdarStorDtl3);

        // when
        List<SvcIndutyDto> result = trdarStorDtlQueryRepository.findTopStorCoByStdrYyquCdAndTrdarCd(stdrYyquCd, trdarCd, topN);

        // then
        assertThat(result.size()).isEqualTo(topN);
        assertThat(result.get(0).getSvcIndutyCd()).isEqualTo("CS100003");
        assertThat(result.get(0).getSvcIndutyNm()).isEqualTo("일식음식점");
        assertThat(result.get(1).getSvcIndutyCd()).isEqualTo("CS100001");
        assertThat(result.get(1).getSvcIndutyNm()).isEqualTo("한식음식점");
    }
}