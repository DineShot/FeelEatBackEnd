package dine.dineshotbackend.badge.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBadge is a Querydsl query type for Badge
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBadge extends EntityPathBase<Badge> {

    private static final long serialVersionUID = 446994533L;

    public static final QBadge badge = new QBadge("badge");

    public final EnumPath<BadgeCategory> badgeCategory = createEnum("badgeCategory", BadgeCategory.class);

    public final NumberPath<Long> badgeCode = createNumber("badgeCode", Long.class);

    public final StringPath badgeExplain = createString("badgeExplain");

    public final NumberPath<Integer> badgeHasUserCount = createNumber("badgeHasUserCount", Integer.class);

    public final StringPath badgeImageName = createString("badgeImageName");

    public final EnumPath<BadgeLevel> badgeLevel = createEnum("badgeLevel", BadgeLevel.class);

    public final StringPath badgeName = createString("badgeName");

    public QBadge(String variable) {
        super(Badge.class, forVariable(variable));
    }

    public QBadge(Path<? extends Badge> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBadge(PathMetadata metadata) {
        super(Badge.class, metadata);
    }

}

