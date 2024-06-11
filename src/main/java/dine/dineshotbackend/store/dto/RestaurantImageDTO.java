package dine.dineshotbackend.store.dto;


import lombok.*;

@AllArgsConstructor@NoArgsConstructor@Getter@Setter@ToString
public class RestaurantImageDTO {
    private Long restaurantImageCode;
    private String restaurantImageOriginal;
    private String restaurantImageChange;
    private String restaurantImageFilePath;
    private boolean restaurantImageIsDelete;
    private Long restaurant;
}
