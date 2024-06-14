package dine.dineshotbackend.store.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NearRestaurantFindDTO {
    private double Latitude; // 위도
    private double Longitude; // 경도
    private double radius; // km 단위 거리 (2 = 2km)
}
