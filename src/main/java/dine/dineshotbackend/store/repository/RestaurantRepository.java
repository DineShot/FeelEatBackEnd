package dine.dineshotbackend.store.repository;

import dine.dineshotbackend.queryDSL.CustomRestaurantRepository;
import dine.dineshotbackend.store.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> , CustomRestaurantRepository {


    // 영업중 on , 주차장 on
    @Query("select r from Restaurant r where r.restaurantName Like %:name% and " +
            ":nowTime between r.restaurantOpenTime and r.restaurantCloseTime and " +
            "r.restaurantHasPark")
    List<Restaurant> findRestaurantOpenTrueParkingTrue(@Param("name")String name, LocalTime nowTime);

    // 영업중 on , 주차장 off
    @Query("select r from Restaurant r where r.restaurantName Like %:name% and " +
            ":nowTime between r.restaurantOpenTime and r.restaurantCloseTime")
    List<Restaurant> findRestaurantIsOpenTrue(@Param("name") String name, @Param("nowTime") LocalTime nowTime);

    // 영업중 off , 주차장 on
    @Query("select r from Restaurant r where r.restaurantName Like %:name% and " +
            "r.restaurantHasPark")
    List<Restaurant> findRestaurantParkingTrue(@Param("name")String name);

    //영업중 off, 주차장 off (제목으로만 검색)
    @Query("select r from Restaurant r where r.restaurantName like %:name%")
    List<Restaurant> findRestaurantByName(@Param("name") String name);


//    @Query(value = "SELECT restaurant_code FROM review WHERE review_registerdate = CURDATE() GROUP BY review_registerdate ORDER BY review_registerdate DESC",nativeQuery = true)
//    List<Restaurant> showRestaurantByReviewCount();

}
