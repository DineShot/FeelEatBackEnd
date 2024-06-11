package dine.dineshotbackend.store.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "restaurant")
@AllArgsConstructor@NoArgsConstructor@Setter@Getter@ToString
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_code")
    private Long restaurantCode;
    @Column(name = "restaurant_name")
    private String restaurantName;
    @Column(name = "restaurant_explain")
    private String restaurantExplain;
    @Column(name = "restaurant_number")
    private String restaurantNumber;
    @Column(name = "restaurant_address")
    private String restaurantAddress;
    @Column(name = "restaurant_address_detail")
    private String restaurantAddressDetail;
    @Column(name = "restaurant_open_date")
    private LocalDate restaurantOpenDate;
    @Column(name = "restaurant_open_time")
    private LocalTime restaurantOpenTime;
    @Column(name = "restaurant_close_time")
    private LocalTime restaurantCloseTime;
    @Column(name = "restaurant_latitude")
    private double restaurantLatitude;
    @Column(name = "restaurant_longitude")
    private double restaurantLongitude;
    @JoinColumn(name = "restaurant_user_code")
    private Long restaurantUserCode;
    @Column(name = "restaurant_has_park")
    private boolean restaurantHasPark;

    //가게 조회하면 이미지도 같이 옴
    @OneToMany(mappedBy = "restaurant",fetch = FetchType.LAZY)
    private List<RestaurantImage> restaurantImageRestaurantCode;
    //가게 조회하면 메뉴도 같이 옴
    @OneToMany(mappedBy = "restaurant",fetch = FetchType.LAZY)
    private List<Menu> restaurantMenu;

    public Restaurant(Long restaurantCode) {
        this.restaurantCode = restaurantCode;
    }
}
