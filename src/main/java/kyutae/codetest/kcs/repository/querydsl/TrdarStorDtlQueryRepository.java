package kyutae.codetest.kcs.repository.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import kyutae.codetest.kcs.entity.QTrdarStorDtl;
import kyutae.codetest.kcs.entity.TrdarStorDtl;
import org.springframework.stereotype.Repository;

@Repository
public class TrdarStorDtlQueryRepository {
    private final JPAQueryFactory queryFactory;

    public TrdarStorDtlQueryRepository(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    public TrdarStorDtl findMaxOpbizRtByStdrYyquCdAndTrdarCd(String stdrYyquCd, String trdarCd) {
        QTrdarStorDtl trdarStorDtl = QTrdarStorDtl.trdarStorDtl;

        return queryFactory
                .selectFrom(trdarStorDtl)
                .where(trdarStorDtl.stdrYyquCd.eq(stdrYyquCd)
                        .and(trdarStorDtl.trdar.trdarCd.eq(trdarCd)))
                .orderBy(trdarStorDtl.opbizRt.desc())
                .fetchFirst();
    }

    public TrdarStorDtl findMaxClsbizRtByStdrYyquCdAndTrdarCd(String stdrYyquCd, String trdarCd) {
        QTrdarStorDtl trdarStorDtl = QTrdarStorDtl.trdarStorDtl;

        return queryFactory
                .selectFrom(trdarStorDtl)
                .where(trdarStorDtl.stdrYyquCd.eq(stdrYyquCd)
                        .and(trdarStorDtl.trdar.trdarCd.eq(trdarCd)))
                .orderBy(trdarStorDtl.clsbizRt.desc())
                .fetchFirst();
    }
}