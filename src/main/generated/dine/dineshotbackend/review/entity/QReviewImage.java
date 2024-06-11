package dine.dineshotbackend.review.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QReviewImage is a Querydsl query type for ReviewImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReviewImage extends EntityPathBase<ReviewImage> {

    private static final long serialVersionUID = -2048567028L;

    public static final QReviewImage reviewImage = new QReviewImage("reviewImage");

    public final NumberPath<Long> reviewCode = createNumber("reviewCode", Long.class);

    public final StringPath reviewImageChange = createString("reviewImageChange");

    public final NumberPath<Long> reviewImageCode = createNumber("reviewImageCode", Long.class);

    public final StringPath reviewImageOriginal = createString("reviewImageOriginal");

    public QReviewImage(String variable) {
        super(ReviewImage.class, forVariable(variable));
    }

    public QReviewImage(Path<? extends ReviewImage> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReviewImage(PathMetadata metadata) {
        super(ReviewImage.class, metadata);
    }

}

