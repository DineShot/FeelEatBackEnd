package dine.dineshotbackend.review.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReview is a Querydsl query type for Review
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReview extends EntityPathBase<Review> {

    private static final long serialVersionUID = -449838705L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReview review = new QReview("review");

    public final ListPath<ReviewImage, QReviewImage> image = this.<ReviewImage, QReviewImage>createList("image", ReviewImage.class, QReviewImage.class, PathInits.DIRECT2);

    public final NumberPath<Long> recommendCount = createNumber("recommendCount", Long.class);

    public final dine.dineshotbackend.store.entity.QRestaurant restaurantCode;

    public final NumberPath<Long> reviewCode = createNumber("reviewCode", Long.class);

    public final StringPath reviewDetail = createString("reviewDetail");

    public final BooleanPath reviewIsOpen = createBoolean("reviewIsOpen");

    public final ListPath<ReviewMenu, QReviewMenu> reviewMenu = this.<ReviewMenu, QReviewMenu>createList("reviewMenu", ReviewMenu.class, QReviewMenu.class, PathInits.DIRECT2);

    public final NumberPath<Float> reviewRate = createNumber("reviewRate", Float.class);

    public final ListPath<ReviewRecommend, QReviewRecommend> reviewRecommend = this.<ReviewRecommend, QReviewRecommend>createList("reviewRecommend", ReviewRecommend.class, QReviewRecommend.class, PathInits.DIRECT2);

    public final DateTimePath<java.util.Date> reviewRegisterDate = createDateTime("reviewRegisterDate", java.util.Date.class);

    public final ListPath<ReviewTag, QReviewTag> tag = this.<ReviewTag, QReviewTag>createList("tag", ReviewTag.class, QReviewTag.class, PathInits.DIRECT2);

    public final dine.dineshotbackend.user.entity.QUser userCode;

    public QReview(String variable) {
        this(Review.class, forVariable(variable), INITS);
    }

    public QReview(Path<? extends Review> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReview(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReview(PathMetadata metadata, PathInits inits) {
        this(Review.class, metadata, inits);
    }

    public QReview(Class<? extends Review> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.restaurantCode = inits.isInitialized("restaurantCode") ? new dine.dineshotbackend.store.entity.QRestaurant(forProperty("restaurantCode")) : null;
        this.userCode = inits.isInitialized("userCode") ? new dine.dineshotbackend.user.entity.QUser(forProperty("userCode")) : null;
    }

}

