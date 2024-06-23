package kyutae.codetest.kcs.repository.querydsl;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kyutae.codetest.kcs.repository.querydsl.dto.BestSalesDto;
import org.springframework.stereotype.Repository;

import static kyutae.codetest.kcs.entity.QSvcIndutyMst.svcIndutyMst;
import static kyutae.codetest.kcs.entity.QTrdarSalesDtl.trdarSalesDtl;

@Repository
public class TrdarSalesDtlQueryRepository {
    private final JPAQueryFactory queryFactory;

    public TrdarSalesDtlQueryRepository(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    public BestSalesDto findBestSalesByStdrYyquCdAndSvcIndutyCdNm(String stdrYyquCd, String svcIndutyCdNm) {
        return queryFactory
                .select(Projections.constructor(BestSalesDto.class,
                        trdarSalesDtl.trdar.trdarCd))
                .from(trdarSalesDtl)
                .join(trdarSalesDtl.svcInduty, svcIndutyMst)
                .where(trdarSalesDtl.stdrYyquCd.eq(stdrYyquCd),
                        svcIndutyMst.svcIndutyCdNm.like("%" + svcIndutyCdNm + "%"))
                .orderBy(trdarSalesDtl.mthSaleAmt.desc())
                .limit(1)
                .fetchOne();
    }
}