package kyutae.codetest.kcs.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTrdarMst is a Querydsl query type for TrdarMst
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTrdarMst extends EntityPathBase<TrdarMst> {

    private static final long serialVersionUID = 753428125L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTrdarMst trdarMst = new QTrdarMst("trdarMst");

    public final StringPath trdarCd = createString("trdarCd");

    public final StringPath trdarCdNm = createString("trdarCdNm");

    public final QTrdarSeMst trdarSe;

    public QTrdarMst(String variable) {
        this(TrdarMst.class, forVariable(variable), INITS);
    }

    public QTrdarMst(Path<? extends TrdarMst> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTrdarMst(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTrdarMst(PathMetadata metadata, PathInits inits) {
        this(TrdarMst.class, metadata, inits);
    }

    public QTrdarMst(Class<? extends TrdarMst> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.trdarSe = inits.isInitialized("trdarSe") ? new QTrdarSeMst(forProperty("trdarSe")) : null;
    }

}

