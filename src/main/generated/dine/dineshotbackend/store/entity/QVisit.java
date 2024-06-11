package dine.dineshotbackend.store.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QVisit is a Querydsl query type for Visit
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QVisit extends EntityPathBase<Visit> {

    private static final long serialVersionUID = -1279270513L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QVisit visit = new QVisit("visit");

    public final QRestaurant restaurantCode;

    public final dine.dineshotbackend.user.entity.QUser UserCode;

    public final NumberPath<Long> visitCode = createNumber("visitCode", Long.class);

    public final StringPath visitTime = createString("visitTime");

    public QVisit(String variable) {
        this(Visit.class, forVariable(variable), INITS);
    }

    public QVisit(Path<? extends Visit> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QVisit(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QVisit(PathMetadata metadata, PathInits inits) {
        this(Visit.class, metadata, inits);
    }

    public QVisit(Class<? extends Visit> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.restaurantCode = inits.isInitialized("restaurantCode") ? new QRestaurant(forProperty("restaurantCode")) : null;
        this.UserCode = inits.isInitialized("UserCode") ? new dine.dineshotbackend.user.entity.QUser(forProperty("UserCode")) : null;
    }

}

