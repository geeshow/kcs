package kyutae.codetest.kcs.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTrdarSalesDtl is a Querydsl query type for TrdarSalesDtl
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTrdarSalesDtl extends EntityPathBase<TrdarSalesDtl> {

    private static final long serialVersionUID = 1837427585L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTrdarSalesDtl trdarSalesDtl = new QTrdarSalesDtl("trdarSalesDtl");

    public final NumberPath<Long> ageGroupSalesAmt10 = createNumber("ageGroupSalesAmt10", Long.class);

    public final NumberPath<Long> ageGroupSalesAmt20 = createNumber("ageGroupSalesAmt20", Long.class);

    public final NumberPath<Long> ageGroupSalesAmt30 = createNumber("ageGroupSalesAmt30", Long.class);

    public final NumberPath<Long> ageGroupSalesAmt40 = createNumber("ageGroupSalesAmt40", Long.class);

    public final NumberPath<Long> ageGroupSalesAmt50 = createNumber("ageGroupSalesAmt50", Long.class);

    public final NumberPath<Long> ageGroupSalesAmt60 = createNumber("ageGroupSalesAmt60", Long.class);

    public final NumberPath<Integer> ageGroupSalesCnt10 = createNumber("ageGroupSalesCnt10", Integer.class);

    public final NumberPath<Integer> ageGroupSalesCnt20 = createNumber("ageGroupSalesCnt20", Integer.class);

    public final NumberPath<Integer> ageGroupSalesCnt30 = createNumber("ageGroupSalesCnt30", Integer.class);

    public final NumberPath<Integer> ageGroupSalesCnt40 = createNumber("ageGroupSalesCnt40", Integer.class);

    public final NumberPath<Integer> ageGroupSalesCnt50 = createNumber("ageGroupSalesCnt50", Integer.class);

    public final NumberPath<Integer> ageGroupSalesCnt60 = createNumber("ageGroupSalesCnt60", Integer.class);

    public final NumberPath<Long> femaleSalesAmt = createNumber("femaleSalesAmt", Long.class);

    public final NumberPath<Integer> femaleSalesCnt = createNumber("femaleSalesCnt", Integer.class);

    public final NumberPath<Long> fridaySalesAmt = createNumber("fridaySalesAmt", Long.class);

    public final NumberPath<Integer> fridaySalesCnt = createNumber("fridaySalesCnt", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> maleSalesAmt = createNumber("maleSalesAmt", Long.class);

    public final NumberPath<Integer> maleSalesCnt = createNumber("maleSalesCnt", Integer.class);

    public final NumberPath<Long> mondaySalesAmt = createNumber("mondaySalesAmt", Long.class);

    public final NumberPath<Integer> mondaySalesCnt = createNumber("mondaySalesCnt", Integer.class);

    public final NumberPath<Long> monthSalesAmt = createNumber("monthSalesAmt", Long.class);

    public final NumberPath<Integer> monthSalesCnt = createNumber("monthSalesCnt", Integer.class);

    public final NumberPath<Long> saturdaySalesAmt = createNumber("saturdaySalesAmt", Long.class);

    public final NumberPath<Integer> saturdaySalesCnt = createNumber("saturdaySalesCnt", Integer.class);

    public final StringPath seoulCd = createString("seoulCd");

    public final StringPath seoulCdNm = createString("seoulCdNm");

    public final StringPath stdrYyquCd = createString("stdrYyquCd");

    public final NumberPath<Long> sundaySalesAmt = createNumber("sundaySalesAmt", Long.class);

    public final NumberPath<Integer> sundaySalesCnt = createNumber("sundaySalesCnt", Integer.class);

    public final QSvcIndutyMst svcInduty;

    public final NumberPath<Long> thursdaySalesAmt = createNumber("thursdaySalesAmt", Long.class);

    public final NumberPath<Integer> thursdaySalesCnt = createNumber("thursdaySalesCnt", Integer.class);

    public final NumberPath<Long> timeSalesAmt0006 = createNumber("timeSalesAmt0006", Long.class);

    public final NumberPath<Long> timeSalesAmt0611 = createNumber("timeSalesAmt0611", Long.class);

    public final NumberPath<Long> timeSalesAmt1114 = createNumber("timeSalesAmt1114", Long.class);

    public final NumberPath<Long> timeSalesAmt1417 = createNumber("timeSalesAmt1417", Long.class);

    public final NumberPath<Long> timeSalesAmt1721 = createNumber("timeSalesAmt1721", Long.class);

    public final NumberPath<Long> timeSalesAmt2124 = createNumber("timeSalesAmt2124", Long.class);

    public final NumberPath<Integer> timeSalesCnt0006 = createNumber("timeSalesCnt0006", Integer.class);

    public final NumberPath<Integer> timeSalesCnt0611 = createNumber("timeSalesCnt0611", Integer.class);

    public final NumberPath<Integer> timeSalesCnt1114 = createNumber("timeSalesCnt1114", Integer.class);

    public final NumberPath<Integer> timeSalesCnt1417 = createNumber("timeSalesCnt1417", Integer.class);

    public final NumberPath<Integer> timeSalesCnt1721 = createNumber("timeSalesCnt1721", Integer.class);

    public final NumberPath<Integer> timeSalesCnt2124 = createNumber("timeSalesCnt2124", Integer.class);

    public final NumberPath<Long> tuesdaySalesAmt = createNumber("tuesdaySalesAmt", Long.class);

    public final NumberPath<Integer> tuesdaySalesCnt = createNumber("tuesdaySalesCnt", Integer.class);

    public final NumberPath<Long> wednesdaySalesAmt = createNumber("wednesdaySalesAmt", Long.class);

    public final NumberPath<Integer> wednesdaySalesCnt = createNumber("wednesdaySalesCnt", Integer.class);

    public final NumberPath<Long> weekdaySalesAmt = createNumber("weekdaySalesAmt", Long.class);

    public final NumberPath<Integer> weekdaySalesCnt = createNumber("weekdaySalesCnt", Integer.class);

    public final NumberPath<Long> weekendSalesAmt = createNumber("weekendSalesAmt", Long.class);

    public final NumberPath<Integer> weekendSalesCnt = createNumber("weekendSalesCnt", Integer.class);

    public QTrdarSalesDtl(String variable) {
        this(TrdarSalesDtl.class, forVariable(variable), INITS);
    }

    public QTrdarSalesDtl(Path<? extends TrdarSalesDtl> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTrdarSalesDtl(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTrdarSalesDtl(PathMetadata metadata, PathInits inits) {
        this(TrdarSalesDtl.class, metadata, inits);
    }

    public QTrdarSalesDtl(Class<? extends TrdarSalesDtl> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.svcInduty = inits.isInitialized("svcInduty") ? new QSvcIndutyMst(forProperty("svcInduty")) : null;
    }

}

