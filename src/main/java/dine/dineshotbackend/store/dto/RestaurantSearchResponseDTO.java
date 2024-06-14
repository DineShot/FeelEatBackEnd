package dine.dineshotbackend.store.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class RestaurantSearchResponseDTO {
    private String restaurantName;
    private String restaurantAddress;
    private String restaurantDetailAddress;
    private String restaurantPhone;
}
