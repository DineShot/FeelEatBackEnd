package dine.dineshotbackend.store.repository;

import dine.dineshotbackend.queryDSL.CustomRestaurantRepository;
import dine.dineshotbackend.store.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> , CustomRestaurantRepository {

    @Query("select r from Restaurant r where r.restaurantName like %:name%")
    List<Restaurant> findRestaurantByName(@Param("name") String name);

    List<Restaurant> findAllByRestaurantNameContaining(String word);


//    @Query(value = "SELECT restaurant_code FROM review WHERE review_registerdate = CURDATE() GROUP BY review_registerdate ORDER BY review_registerdate DESC",nativeQuery = true)
//    List<Restaurant> showRestaurantByReviewCount();

}
