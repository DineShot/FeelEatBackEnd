package dine.dineshotbackend.review.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter@Getter@ToString
public class ReviewWriteDTO {
    private Long restaurantCode;
    private List<String> tags;
    private List<String> images;
    private String reviewDetail;
}
