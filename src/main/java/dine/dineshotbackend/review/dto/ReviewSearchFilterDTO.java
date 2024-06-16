package dine.dineshotbackend.review.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReviewSearchFilterDTO {


    private double latitude; // 위도
    private double longitude; // 경도
    private double radius; // km 단위 거리 (2 = 2km)

    @Schema(description = "필수X")
    private boolean orderByRecommend ; // 추천순정렬 옵션
}
