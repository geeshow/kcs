package kyutae.codetest.kcs.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSvcIndutyMst is a Querydsl query type for SvcIndutyMst
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSvcIndutyMst extends EntityPathBase<SvcIndutyMst> {

    private static final long serialVersionUID = -1260151431L;

    public static final QSvcIndutyMst svcIndutyMst = new QSvcIndutyMst("svcIndutyMst");

    public final StringPath svcIndutyCd = createString("svcIndutyCd");

    public final StringPath svcIndutyCdNm = createString("svcIndutyCdNm");

    public QSvcIndutyMst(String variable) {
        super(SvcIndutyMst.class, forVariable(variable));
    }

    public QSvcIndutyMst(Path<? extends SvcIndutyMst> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSvcIndutyMst(PathMetadata metadata) {
        super(SvcIndutyMst.class, metadata);
    }

}

