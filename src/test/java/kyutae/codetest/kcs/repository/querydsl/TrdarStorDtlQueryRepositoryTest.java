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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@Import({QueryDslConfig.class, TrdarStorDtlQueryRepository.class})
class TrdarStorDtlQueryRepositoryTest {
    @Autowired
    private TrdarStorDtlQueryRepository trdarStorDtlQueryRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void findMaxOpbizRtByStdrYyquCdAndTrdarCd_shouldReturnSvcIndutyDto() {
        // given
        String stdrYyquCd = "20231";
        String trdarCd = "3001491";

        // 테스트 데이터 준비
        TrdarSeMst trdarSeMst = new TrdarSeMst("A", "골목상권");
        entityManager.persist(trdarSeMst);

        TrdarMst trdarMst = new TrdarMst(trdarCd, "상권명", trdarSeMst);
        entityManager.persist(trdarMst);

        SvcIndutyMst svcIndutyMst1 = new SvcIndutyMst("CS100001", "한식음식점");
        entityManager.persist(svcIndutyMst1);

        SvcIndutyMst svcIndutyMst2 = new SvcIndutyMst("CS100002", "중식음식점");
        entityManager.persist(svcIndutyMst2);

        TrdarStorDtl trdarStorDtl1 = createTrdarStorDtl(stdrYyquCd, trdarMst, svcIndutyMst1, 80);
        TrdarStorDtl trdarStorDtl2 = createTrdarStorDtl(stdrYyquCd, trdarMst, svcIndutyMst2, 70);
        entityManager.persist(trdarStorDtl1);
        entityManager.persist(trdarStorDtl2);
        entityManager.flush();
        entityManager.clear();

        // when
        SvcIndutyDto result = trdarStorDtlQueryRepository.findMaxOpbizRtByStdrYyquCdAndTrdarCd(stdrYyquCd, trdarCd);

        // then
        assertThat(result).isNotNull();
        assertThat(result.getSvcIndutyCd()).isEqualTo("CS100001");
        assertThat(result.getSvcIndutyNm()).isEqualTo("한식음식점");
    }

    private TrdarStorDtl createTrdarStorDtl(String stdrYyquCd, TrdarMst trdarMst, SvcIndutyMst svcIndutyMst, int opbizRt) {
        return TrdarStorDtl.builder()
                .stdrYyquCd(stdrYyquCd)
                .trdar(trdarMst)
                .svcInduty(svcIndutyMst)
                .opbizRt(opbizRt)
                .build();
    }
}