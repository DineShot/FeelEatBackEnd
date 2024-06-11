package dine.dineshotbackend.queryDSL.impl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import dine.dineshotbackend.queryDSL.CustomRestaurantRepository;
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
}
