package dine.dineshotbackend.store.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class NearRestaurantResponseDTO {
    @Schema(example = "1")
    private Long restaurantCode;
    @Schema(example = "우리집비어")
    private String restaurantName;
    @Schema(example = "13년째 이어오는 전설의 맛집!!")
    private String restaurantExplain;
    @Schema(example = "130.2524")
    private double restaurantLatitude;
    @Schema(example = "30.2525")
    private double restaurantLongitude;
}
