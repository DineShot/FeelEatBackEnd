package dine.dineshotbackend.store.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QRestaurantImage is a Querydsl query type for RestaurantImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRestaurantImage extends EntityPathBase<RestaurantImage> {

    private static final long serialVersionUID = 1678900066L;

    public static final QRestaurantImage restaurantImage = new QRestaurantImage("restaurantImage");

    public final NumberPath<Long> restaurant = createNumber("restaurant", Long.class);

    public final StringPath restaurantImageChange = createString("restaurantImageChange");

    public final NumberPath<Long> restaurantImageCode = createNumber("restaurantImageCode", Long.class);

    public final StringPath restaurantImageFilePath = createString("restaurantImageFilePath");

    public final BooleanPath restaurantImageIsDelete = createBoolean("restaurantImageIsDelete");

    public final StringPath restaurantImageOriginal = createString("restaurantImageOriginal");

    public QRestaurantImage(String variable) {
        super(RestaurantImage.class, forVariable(variable));
    }

    public QRestaurantImage(Path<? extends RestaurantImage> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRestaurantImage(PathMetadata metadata) {
        super(RestaurantImage.class, metadata);
    }

}

