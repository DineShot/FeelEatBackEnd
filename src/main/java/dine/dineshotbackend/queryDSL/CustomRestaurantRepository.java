package dine.dineshotbackend.queryDSL;

import dine.dineshotbackend.store.dto.NearRestaurantFindDTO;
import dine.dineshotbackend.store.dto.RestaurantFindFilterDTO;
import dine.dineshotbackend.store.entity.Restaurant;

import java.util.List;

public interface CustomRestaurantRepository {
    List<Restaurant> findRestaurantWithFilter(RestaurantFindFilterDTO restaurantFindFilterDTO);

    List<Restaurant> findNearRestaurantList(NearRestaurantFindDTO dto);
}
