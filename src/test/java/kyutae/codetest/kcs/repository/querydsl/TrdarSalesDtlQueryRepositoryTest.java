package kyutae.codetest.kcs.repository.querydsl;

import jakarta.persistence.EntityManager;
import kyutae.codetest.kcs.config.QueryDslConfig;
import kyutae.codetest.kcs.entity.SvcIndutyMst;
import kyutae.codetest.kcs.entity.TrdarMst;
import kyutae.codetest.kcs.entity.TrdarSalesDtl;
import kyutae.codetest.kcs.entity.TrdarSeMst;
import kyutae.codetest.kcs.repository.querydsl.dto.BestSalesDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import({QueryDslConfig.class, TrdarSalesDtlQueryRepository.class})
class TrdarSalesDtlQueryRepositoryTest {
    @Autowired
    private TrdarSalesDtlQueryRepository trdarSalesDtlQueryRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void findBestSalesByStdrYyquCdAndSvcIndutyCdNm_shouldReturnBestSalesDto() {
        // given
        String stdrYyquCd = "20231";
        String svcIndutyCdNm = "음식점";

        TrdarSeMst trdarSeMst = new TrdarSeMst("A", "골목상권");
        TrdarMst trdarMst1 = new TrdarMst("1", "상권1", trdarSeMst);
        TrdarMst trdarMst2 = new TrdarMst("2", "상권2", trdarSeMst);
        entityManager.persist(trdarSeMst);
        entityManager.persist(trdarMst1);
        entityManager.persist(trdarMst2);

        SvcIndutyMst svcIndutyMst1 = new SvcIndutyMst("CS100001", "한식음식점");
        SvcIndutyMst svcIndutyMst2 = new SvcIndutyMst("CS100002", "중식음식점");
        entityManager.persist(svcIndutyMst1);
        entityManager.persist(svcIndutyMst2);

        TrdarSalesDtl trdarSalesDtl1 = TrdarSalesDtl.builder()
                .stdrYyquCd(stdrYyquCd)
                .trdar(trdarMst1)
                .svcInduty(svcIndutyMst1)
                .mthSaleAmt(1000L)
                .build();
        TrdarSalesDtl trdarSalesDtl2 = TrdarSalesDtl.builder()
                .stdrYyquCd(stdrYyquCd)
                .trdar(trdarMst2)
                .svcInduty(svcIndutyMst2)
                .mthSaleAmt(2000L)
                .build();
        entityManager.persist(trdarSalesDtl1);
        entityManager.persist(trdarSalesDtl2);

        // when
        BestSalesDto result = trdarSalesDtlQueryRepository.findBestSalesByStdrYyquCdAndSvcIndutyCdNm(stdrYyquCd, svcIndutyCdNm);

        // then
        assertThat(result).isNotNull();
        assertThat(result.getTrdarCd()).isEqualTo("2");
    }
}