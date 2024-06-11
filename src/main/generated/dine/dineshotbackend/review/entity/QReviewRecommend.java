package dine.dineshotbackend.review.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReviewRecommend is a Querydsl query type for ReviewRecommend
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReviewRecommend extends EntityPathBase<ReviewRecommend> {

    private static final long serialVersionUID = 1638891501L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReviewRecommend reviewRecommend = new QReviewRecommend("reviewRecommend");

    public final QReview reviewCode;

    public final DatePath<java.time.LocalDate> reviewRecommendDate = createDate("reviewRecommendDate", java.time.LocalDate.class);

    public final dine.dineshotbackend.user.entity.QUser userCode;

    public QReviewRecommend(String variable) {
        this(ReviewRecommend.class, forVariable(variable), INITS);
    }

    public QReviewRecommend(Path<? extends ReviewRecommend> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReviewRecommend(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReviewRecommend(PathMetadata metadata, PathInits inits) {
        this(ReviewRecommend.class, metadata, inits);
    }

    public QReviewRecommend(Class<? extends ReviewRecommend> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.reviewCode = inits.isInitialized("reviewCode") ? new QReview(forProperty("reviewCode"), inits.get("reviewCode")) : null;
        this.userCode = inits.isInitialized("userCode") ? new dine.dineshotbackend.user.entity.QUser(forProperty("userCode")) : null;
    }

}

