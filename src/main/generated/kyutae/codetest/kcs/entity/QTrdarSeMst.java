package kyutae.codetest.kcs.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QTrdarSeMst is a Querydsl query type for TrdarSeMst
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTrdarSeMst extends EntityPathBase<TrdarSeMst> {

    private static final long serialVersionUID = -1799954645L;

    public static final QTrdarSeMst trdarSeMst = new QTrdarSeMst("trdarSeMst");

    public final StringPath trdarSeCd = createString("trdarSeCd");

    public final StringPath trdarSeCdNm = createString("trdarSeCdNm");

    public QTrdarSeMst(String variable) {
        super(TrdarSeMst.class, forVariable(variable));
    }

    public QTrdarSeMst(Path<? extends TrdarSeMst> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTrdarSeMst(PathMetadata metadata) {
        super(TrdarSeMst.class, metadata);
    }

}

