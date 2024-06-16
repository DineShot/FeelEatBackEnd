package dine.dineshotbackend.user.dto;

import dine.dineshotbackend.store.dto.RestaurantDTO;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter@Getter@ToString
public class RestaurantAndUserDTO {
    private List<UserFindDTO> user;
    private List<RestaurantSearchDTO> restaurant;

}
