package dine.dineshotbackend.store.dto;

import dine.dineshotbackend.store.entity.RestaurantImage;
import lombok.*;

import java.util.List;

@AllArgsConstructor@NoArgsConstructor@Setter@Getter@ToString
public class RestaurantDTO {
    private Long restaurantCode;
    private String restaurantName;
    private String restaurantExplain;
    private String restaurantNumber;
    private String restaurantAddress;
    private String restaurantAddressDetail;
    private String restaurantOpenDate;
    private String restaurantOpenTime;
    private String restaurantCloseTime;
    private double restaurantLatitude;
    private double restaurantLongitude;
    private Long user;
    private List<RestaurantImage> restaurantImageRestaurantCode;
}
