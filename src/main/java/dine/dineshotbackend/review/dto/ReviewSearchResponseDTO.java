package dine.dineshotbackend.review.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Schema(name = "필터를 통한 리뷰 검색 응답DTO",description = "DTO 들의 List 를 반환합니다.")
public class ReviewSearchResponseDTO {
    @Schema(title = "리뷰의 ID값",example = "2")
    private Long reviewCode;
    @Schema(title = "리뷰의 상세내용",example = "이집 진짜진짜맛있다!!!")
    private String reviewDetail;
    @Schema(title = "리뷰가 작성된 가게의 위도",description = "리뷰가 작성된 가게의 위도",example = "113.33")
    private double latitude ;
    @Schema(title = "리뷰가 작성된 가게의 경도",description = "리뷰가 작성된 가게의 경도",example = "30.33")
    private double longitude ;
}
