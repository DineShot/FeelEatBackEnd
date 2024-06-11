package dine.dineshotbackend.store.dto;

import lombok.*;

@AllArgsConstructor@NoArgsConstructor@Setter@Getter@ToString
public class RestaurantAndImageDTO {
    private RestaurantDTO restaurant;
    private RestaurantImageDTO restaurantImage;
}
