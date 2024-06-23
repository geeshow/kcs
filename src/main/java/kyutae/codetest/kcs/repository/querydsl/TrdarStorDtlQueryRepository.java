package kyutae.codetest.kcs.repository.querydsl;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kyutae.codetest.kcs.repository.querydsl.dto.SvcIndutyDto;
import kyutae.codetest.kcs.entity.QTrdarStorDtl;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TrdarStorDtlQueryRepository {
    private final JPAQueryFactory queryFactory;

    public TrdarStorDtlQueryRepository(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    public SvcIndutyDto findMaxOpbizRtByStdrYyquCdAndTrdarCd(String stdrYyquCd, String trdarCd) {
        QTrdarStorDtl trdarStorDtl = QTrdarStorDtl.trdarStorDtl;

        return queryFactory
                .select(Projections.constructor(SvcIndutyDto.class,
                        trdarStorDtl.svcInduty.svcIndutyCd,
                        trdarStorDtl.svcInduty.svcIndutyCdNm))
                .from(trdarStorDtl)
                .where(trdarStorDtl.stdrYyquCd.eq(stdrYyquCd)
                        .and(trdarStorDtl.trdar.trdarCd.eq(trdarCd)))
                .orderBy(trdarStorDtl.opbizRt.desc())
                .fetchFirst();
    }

    public SvcIndutyDto findMaxClsbizRtByStdrYyquCdAndTrdarCd(String stdrYyquCd, String trdarCd) {
        QTrdarStorDtl trdarStorDtl = QTrdarStorDtl.trdarStorDtl;

        return queryFactory
                .select(Projections.constructor(SvcIndutyDto.class,
                        trdarStorDtl.svcInduty.svcIndutyCd,
                        trdarStorDtl.svcInduty.svcIndutyCdNm))
                .from(trdarStorDtl)
                .where(trdarStorDtl.stdrYyquCd.eq(stdrYyquCd)
                        .and(trdarStorDtl.trdar.trdarCd.eq(trdarCd)))
                .orderBy(trdarStorDtl.clsbizRt.desc())
                .fetchFirst();
    }

    public List<SvcIndutyDto> findTopStorCoByStdrYyquCdAndTrdarCd(String stdrYyquCd, String trdarCd, int topN) {
        QTrdarStorDtl trdarStorDtl = QTrdarStorDtl.trdarStorDtl;

        return queryFactory
                .select(Projections.constructor(SvcIndutyDto.class,
                        trdarStorDtl.svcInduty.svcIndutyCd,
                        trdarStorDtl.svcInduty.svcIndutyCdNm))
                .from(trdarStorDtl)
                .where(trdarStorDtl.stdrYyquCd.eq(stdrYyquCd)
                        .and(trdarStorDtl.trdar.trdarCd.eq(trdarCd)))
                .orderBy(trdarStorDtl.storCo.desc())
                .limit(topN)
                .fetch();
    }
}