package dine.dineshotbackend.store.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QRestaurantCategory is a Querydsl query type for RestaurantCategory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRestaurantCategory extends EntityPathBase<RestaurantCategory> {

    private static final long serialVersionUID = 2127911319L;

    public static final QRestaurantCategory restaurantCategory = new QRestaurantCategory("restaurantCategory");

    public final NumberPath<Long> restaurantCategoryCode = createNumber("restaurantCategoryCode", Long.class);

    public final StringPath restaurantCategoryName = createString("restaurantCategoryName");

    public final NumberPath<Long> restaurantCode = createNumber("restaurantCode", Long.class);

    public QRestaurantCategory(String variable) {
        super(RestaurantCategory.class, forVariable(variable));
    }

    public QRestaurantCategory(Path<? extends RestaurantCategory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRestaurantCategory(PathMetadata metadata) {
        super(RestaurantCategory.class, metadata);
    }

}

