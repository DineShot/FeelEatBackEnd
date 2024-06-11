package dine.dineshotbackend.review.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter@ToString
public class ReviewImageDTO {
    private Long restaurantImageCode;
    private String restaurantImageOriginal;
    private String restaurantImageChange;
    private String restaurantImageFilePath;
    private boolean restaurantImageIsDelete;
    private Long restaurant;
}
