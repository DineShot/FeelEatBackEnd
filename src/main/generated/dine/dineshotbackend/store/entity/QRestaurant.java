package dine.dineshotbackend.store.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRestaurant is a Querydsl query type for Restaurant
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRestaurant extends EntityPathBase<Restaurant> {

    private static final long serialVersionUID = -1141849735L;

    public static final QRestaurant restaurant = new QRestaurant("restaurant");

    public final StringPath restaurantAddress = createString("restaurantAddress");

    public final StringPath restaurantAddressDetail = createString("restaurantAddressDetail");

    public final TimePath<java.time.LocalTime> restaurantCloseTime = createTime("restaurantCloseTime", java.time.LocalTime.class);

    public final NumberPath<Long> restaurantCode = createNumber("restaurantCode", Long.class);

    public final StringPath restaurantExplain = createString("restaurantExplain");

    public final BooleanPath restaurantHasPark = createBoolean("restaurantHasPark");

    public final ListPath<RestaurantImage, QRestaurantImage> restaurantImageRestaurantCode = this.<RestaurantImage, QRestaurantImage>createList("restaurantImageRestaurantCode", RestaurantImage.class, QRestaurantImage.class, PathInits.DIRECT2);

    public final NumberPath<Double> restaurantLatitude = createNumber("restaurantLatitude", Double.class);

    public final NumberPath<Double> restaurantLongitude = createNumber("restaurantLongitude", Double.class);

    public final ListPath<Menu, QMenu> restaurantMenu = this.<Menu, QMenu>createList("restaurantMenu", Menu.class, QMenu.class, PathInits.DIRECT2);

    public final StringPath restaurantName = createString("restaurantName");

    public final StringPath restaurantNumber = createString("restaurantNumber");

    public final DatePath<java.time.LocalDate> restaurantOpenDate = createDate("restaurantOpenDate", java.time.LocalDate.class);

    public final TimePath<java.time.LocalTime> restaurantOpenTime = createTime("restaurantOpenTime", java.time.LocalTime.class);

    public final NumberPath<Long> restaurantUserCode = createNumber("restaurantUserCode", Long.class);

    public QRestaurant(String variable) {
        super(Restaurant.class, forVariable(variable));
    }

    public QRestaurant(Path<? extends Restaurant> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRestaurant(PathMetadata metadata) {
        super(Restaurant.class, metadata);
    }

}

