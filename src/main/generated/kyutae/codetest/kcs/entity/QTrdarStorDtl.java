package kyutae.codetest.kcs.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTrdarStorDtl is a Querydsl query type for TrdarStorDtl
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTrdarStorDtl extends EntityPathBase<TrdarStorDtl> {

    private static final long serialVersionUID = 1576171207L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTrdarStorDtl trdarStorDtl = new QTrdarStorDtl("trdarStorDtl");

    public final NumberPath<Integer> clsbizRt = createNumber("clsbizRt", Integer.class);

    public final NumberPath<Integer> clsbizStorCo = createNumber("clsbizStorCo", Integer.class);

    public final NumberPath<Integer> frcStorCo = createNumber("frcStorCo", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> opbizRt = createNumber("opbizRt", Integer.class);

    public final NumberPath<Integer> opbizStorCo = createNumber("opbizStorCo", Integer.class);

    public final NumberPath<Integer> similrIndutyStorCo = createNumber("similrIndutyStorCo", Integer.class);

    public final StringPath stdrYyquCd = createString("stdrYyquCd");

    public final NumberPath<Integer> storCo = createNumber("storCo", Integer.class);

    public final QSvcIndutyMst svcInduty;

    public final QTrdarMst trdar;

    public QTrdarStorDtl(String variable) {
        this(TrdarStorDtl.class, forVariable(variable), INITS);
    }

    public QTrdarStorDtl(Path<? extends TrdarStorDtl> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTrdarStorDtl(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTrdarStorDtl(PathMetadata metadata, PathInits inits) {
        this(TrdarStorDtl.class, metadata, inits);
    }

    public QTrdarStorDtl(Class<? extends TrdarStorDtl> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.svcInduty = inits.isInitialized("svcInduty") ? new QSvcIndutyMst(forProperty("svcInduty")) : null;
        this.trdar = inits.isInitialized("trdar") ? new QTrdarMst(forProperty("trdar"), inits.get("trdar")) : null;
    }

}

