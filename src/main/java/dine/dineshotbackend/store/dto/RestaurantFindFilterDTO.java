package dine.dineshotbackend.store.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RestaurantFindFilterDTO {
    private String restaurantName;
    private boolean nowOpeninOption;
    private boolean hasParkingOption;
}
