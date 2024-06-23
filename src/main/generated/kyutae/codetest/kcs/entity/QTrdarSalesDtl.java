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

    public final NumberPath<Long> ageG10SaleAmt = createNumber("ageG10SaleAmt", Long.class);

    public final NumberPath<Long> ageG10SaleCnt = createNumber("ageG10SaleCnt", Long.class);

    public final NumberPath<Long> ageG20SaleAmt = createNumber("ageG20SaleAmt", Long.class);

    public final NumberPath<Long> ageG20SaleCnt = createNumber("ageG20SaleCnt", Long.class);

    public final NumberPath<Long> ageG30SaleAmt = createNumber("ageG30SaleAmt", Long.class);

    public final NumberPath<Long> ageG30SaleCnt = createNumber("ageG30SaleCnt", Long.class);

    public final NumberPath<Long> ageG40SaleAmt = createNumber("ageG40SaleAmt", Long.class);

    public final NumberPath<Long> ageG40SaleCnt = createNumber("ageG40SaleCnt", Long.class);

    public final NumberPath<Long> ageG50SaleAmt = createNumber("ageG50SaleAmt", Long.class);

    public final NumberPath<Long> ageG50SaleCnt = createNumber("ageG50SaleCnt", Long.class);

    public final NumberPath<Long> ageG60UppSaleAmt = createNumber("ageG60UppSaleAmt", Long.class);

    public final NumberPath<Long> ageG60UppSaleCnt = createNumber("ageG60UppSaleCnt", Long.class);

    public final NumberPath<Long> femaleSaleAmt = createNumber("femaleSaleAmt", Long.class);

    public final NumberPath<Long> femaleSaleCnt = createNumber("femaleSaleCnt", Long.class);

    public final NumberPath<Long> friSaleAmt = createNumber("friSaleAmt", Long.class);

    public final NumberPath<Long> friSaleCnt = createNumber("friSaleCnt", Long.class);

    public final NumberPath<Long> holidayAvgSaleAmt = createNumber("holidayAvgSaleAmt", Long.class);

    public final NumberPath<Long> holidayAvgSaleCnt = createNumber("holidayAvgSaleCnt", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> maleSaleAmt = createNumber("maleSaleAmt", Long.class);

    public final NumberPath<Long> maleSaleCnt = createNumber("maleSaleCnt", Long.class);

    public final NumberPath<Long> monSaleAmt = createNumber("monSaleAmt", Long.class);

    public final NumberPath<Long> monSaleCnt = createNumber("monSaleCnt", Long.class);

    public final NumberPath<Long> mthSaleAmt = createNumber("mthSaleAmt", Long.class);

    public final NumberPath<Long> mthSaleCnt = createNumber("mthSaleCnt", Long.class);

    public final NumberPath<Long> satSaleAmt = createNumber("satSaleAmt", Long.class);

    public final NumberPath<Long> satSaleCnt = createNumber("satSaleCnt", Long.class);

    public final StringPath stdrYyquCd = createString("stdrYyquCd");

    public final NumberPath<Long> sunSaleAmt = createNumber("sunSaleAmt", Long.class);

    public final NumberPath<Long> sunSaleCnt = createNumber("sunSaleCnt", Long.class);

    public final QSvcIndutyMst svcInduty;

    public final NumberPath<Long> thuSaleAmt = createNumber("thuSaleAmt", Long.class);

    public final NumberPath<Long> thuSaleCnt = createNumber("thuSaleCnt", Long.class);

    public final NumberPath<Long> tmzon00SaleAmt = createNumber("tmzon00SaleAmt", Long.class);

    public final NumberPath<Long> tmzon00SaleCnt = createNumber("tmzon00SaleCnt", Long.class);

    public final NumberPath<Long> tmzon06SaleAmt = createNumber("tmzon06SaleAmt", Long.class);

    public final NumberPath<Long> tmzon06SaleCnt = createNumber("tmzon06SaleCnt", Long.class);

    public final NumberPath<Long> tmzon11SaleAmt = createNumber("tmzon11SaleAmt", Long.class);

    public final NumberPath<Long> tmzon11SaleCnt = createNumber("tmzon11SaleCnt", Long.class);

    public final NumberPath<Long> tmzon14SaleAmt = createNumber("tmzon14SaleAmt", Long.class);

    public final NumberPath<Long> tmzon14SaleCnt = createNumber("tmzon14SaleCnt", Long.class);

    public final NumberPath<Long> tmzon17SaleAmt = createNumber("tmzon17SaleAmt", Long.class);

    public final NumberPath<Long> tmzon17SaleCnt = createNumber("tmzon17SaleCnt", Long.class);

    public final NumberPath<Long> tmzon21SaleAmt = createNumber("tmzon21SaleAmt", Long.class);

    public final NumberPath<Long> tmzon21SaleCnt = createNumber("tmzon21SaleCnt", Long.class);

    public final QTrdarMst trdar;

    public final NumberPath<Long> tueSaleAmt = createNumber("tueSaleAmt", Long.class);

    public final NumberPath<Long> tueSaleCnt = createNumber("tueSaleCnt", Long.class);

    public final NumberPath<Long> wedSaleAmt = createNumber("wedSaleAmt", Long.class);

    public final NumberPath<Long> wedSaleCnt = createNumber("wedSaleCnt", Long.class);

    public final NumberPath<Long> weekdayAvgSaleAmt = createNumber("weekdayAvgSaleAmt", Long.class);

    public final NumberPath<Long> weekdayAvgSaleCnt = createNumber("weekdayAvgSaleCnt", Long.class);

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
        this.trdar = inits.isInitialized("trdar") ? new QTrdarMst(forProperty("trdar"), inits.get("trdar")) : null;
    }

}

