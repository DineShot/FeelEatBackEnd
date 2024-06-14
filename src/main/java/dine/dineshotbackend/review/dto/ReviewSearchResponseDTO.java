package dine.dineshotbackend.review.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ReviewSearchResponseDTO {
    private Long reviewCode;
    private String reviewDetail;
    private double Latitude ;
    private double Longitude ;
}
