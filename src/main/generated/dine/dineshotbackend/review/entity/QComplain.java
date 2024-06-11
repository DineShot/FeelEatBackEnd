package dine.dineshotbackend.review.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QComplain is a Querydsl query type for Complain
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QComplain extends EntityPathBase<Complain> {

    private static final long serialVersionUID = 1158445408L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QComplain complain = new QComplain("complain");

    public final QReview reviewCode;

    public final dine.dineshotbackend.user.entity.QUser userCode;

    public QComplain(String variable) {
        this(Complain.class, forVariable(variable), INITS);
    }

    public QComplain(Path<? extends Complain> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QComplain(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QComplain(PathMetadata metadata, PathInits inits) {
        this(Complain.class, metadata, inits);
    }

    public QComplain(Class<? extends Complain> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.reviewCode = inits.isInitialized("reviewCode") ? new QReview(forProperty("reviewCode"), inits.get("reviewCode")) : null;
        this.userCode = inits.isInitialized("userCode") ? new dine.dineshotbackend.user.entity.QUser(forProperty("userCode")) : null;
    }

}

