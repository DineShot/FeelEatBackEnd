package dine.dineshotbackend.review.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReviewSearchFilterDTO {
    private double Latitude; // 위도
    private double Longitude; // 경도
    private double radius; // km 단위 거리 (2 = 2km)
}
