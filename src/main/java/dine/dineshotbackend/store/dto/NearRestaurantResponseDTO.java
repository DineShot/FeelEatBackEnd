package dine.dineshotbackend.store.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class NearRestaurantResponseDTO {
    private Long restaurantCode;
    private String restaurantName;
    private String restaurantExplain;
    private double restaurantLatitude;
    private double restaurantLongitude;
}
