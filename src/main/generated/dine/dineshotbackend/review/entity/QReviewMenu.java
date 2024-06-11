package dine.dineshotbackend.review.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReviewMenu is a Querydsl query type for ReviewMenu
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReviewMenu extends EntityPathBase<ReviewMenu> {

    private static final long serialVersionUID = -481612914L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReviewMenu reviewMenu = new QReviewMenu("reviewMenu");

    public final dine.dineshotbackend.store.entity.QMenu menuCode;

    public final QReview reviewCode;

    public final NumberPath<Long> reviewMenuCode = createNumber("reviewMenuCode", Long.class);

    public QReviewMenu(String variable) {
        this(ReviewMenu.class, forVariable(variable), INITS);
    }

    public QReviewMenu(Path<? extends ReviewMenu> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReviewMenu(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReviewMenu(PathMetadata metadata, PathInits inits) {
        this(ReviewMenu.class, metadata, inits);
    }

    public QReviewMenu(Class<? extends ReviewMenu> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.menuCode = inits.isInitialized("menuCode") ? new dine.dineshotbackend.store.entity.QMenu(forProperty("menuCode")) : null;
        this.reviewCode = inits.isInitialized("reviewCode") ? new QReview(forProperty("reviewCode"), inits.get("reviewCode")) : null;
    }

}

