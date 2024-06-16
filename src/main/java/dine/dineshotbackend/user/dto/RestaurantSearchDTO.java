package dine.dineshotbackend.user.dto;

import dine.dineshotbackend.store.entity.RestaurantImage;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter@Getter@ToString
public class RestaurantSearchDTO {
    private Long restaurantCode;
    private String restaurantName;
    private String restaurantAddress;
    private String restaurantAddressDetail;
    private String restaurantOpenTime;
    private String restaurantCloseTime;
    private String restaurantImage;
}
