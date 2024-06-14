package dine.dineshotbackend.queryDSL.impl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import dine.dineshotbackend.queryDSL.CustomRestaurantRepository;
import dine.dineshotbackend.review.dto.ReviewSearchFilterDTO;
import dine.dineshotbackend.store.dto.NearRestaurantFindDTO;
import dine.dineshotbackend.store.dto.RestaurantFindFilterDTO;
import dine.dineshotbackend.store.entity.Restaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;
import static dine.dineshotbackend.store.entity.QRestaurant.restaurant;
@RequiredArgsConstructor
@Repository
public class CustomRestaurantRepositoryImpl implements CustomRestaurantRepository {
    private final JPAQueryFactory queryFactory;

    @Override // 필터를 통한 가게 검색
    public List<Restaurant> findRestaurantWithFilter(RestaurantFindFilterDTO filterDTO) {
        return queryFactory.selectFrom(restaurant)
                .where(containName(filterDTO.getRestaurantName())
                ,openTimeOption(filterDTO.isNowOpeninOption())
                ,parkingOption(filterDTO.isHasParkingOption()))
                .fetch();
    }

    private BooleanExpression containName(String name){
        if(name.length() > 1){ // 2글자 이상부터 검색가능
            return restaurant.restaurantName.contains(name);
        }
        return null;
    }
    private BooleanExpression openTimeOption(boolean openTimeOption) {
        if (openTimeOption){
            LocalTime now = LocalTime.now();
            return restaurant.restaurantOpenTime.before(now).and(restaurant.restaurantCloseTime.after(now));
        }
        return null;
    }
    private BooleanExpression parkingOption(boolean parkingOption) {
        if (parkingOption){
            return restaurant.restaurantHasPark.isTrue();
        }
        return null;
    }

    @Override
    public List<Restaurant> findNearRestaurantList(NearRestaurantFindDTO dto) {
        return queryFactory.selectFrom(restaurant)
                .where(nearReview(dto))
                .fetch();
    }

    /**
     * 위도 경도를 이용한 리뷰 검색 필터
     */
    private BooleanExpression nearReview(NearRestaurantFindDTO dto) {
        double lat1 = dto.getLatitude();
        double lon1 = dto.getLongitude();
        double radius = dto.getRadius(); // 반경 (킬로미터 단위)
        System.out.println("dto = " + dto);

        // 하버사인 공식을 사용하여 두 지점 간의 거리를 계산하는 SQL 표현식
        NumberExpression<Double> distance = Expressions.numberTemplate(Double.class,
                "6371 * acos(cos(radians({0})) * cos(radians({1})) * cos(radians({2}) - radians({3})) + sin(radians({0})) * sin(radians({1})))",
                lat1, restaurant.restaurantLatitude, restaurant.restaurantLongitude, lon1);

        // 반경 이내의 장소 필터링 (loe = less than or equal to = 이하)
        return distance.loe(radius);
    }
}
