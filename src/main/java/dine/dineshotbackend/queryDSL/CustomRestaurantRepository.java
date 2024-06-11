package dine.dineshotbackend.queryDSL;

import dine.dineshotbackend.store.dto.RestaurantFindFilterDTO;
import dine.dineshotbackend.store.entity.Restaurant;

import java.util.List;

public interface CustomRestaurantRepository {
    List<Restaurant> findRestaurantWithFilter(RestaurantFindFilterDTO restaurantFindFilterDTO);
}
