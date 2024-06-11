package dine.dineshotbackend.review.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter@Getter@ToString
public class ReviewTagDTO {
    private Long reviewTagCode;

    private String reviewTagName;

    private Long reviewCode;
}
