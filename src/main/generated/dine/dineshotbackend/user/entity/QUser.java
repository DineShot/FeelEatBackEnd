package dine.dineshotbackend.user.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 707305525L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUser user = new QUser("user");

    public final StringPath userAddress = createString("userAddress");

    public final NumberPath<Long> userCode = createNumber("userCode", Long.class);

    public final dine.dineshotbackend.badge.entity.QBadge userEquipBadge;

    public final NumberPath<Integer> userFollwerCount = createNumber("userFollwerCount", Integer.class);

    public final BooleanPath userIsCEO = createBoolean("userIsCEO");

    public final StringPath userName = createString("userName");

    public final StringPath userProfileImg = createString("userProfileImg");

    public final StringPath userRole = createString("userRole");

    public QUser(String variable) {
        this(User.class, forVariable(variable), INITS);
    }

    public QUser(Path<? extends User> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUser(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUser(PathMetadata metadata, PathInits inits) {
        this(User.class, metadata, inits);
    }

    public QUser(Class<? extends User> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.userEquipBadge = inits.isInitialized("userEquipBadge") ? new dine.dineshotbackend.badge.entity.QBadge(forProperty("userEquipBadge")) : null;
    }

}

