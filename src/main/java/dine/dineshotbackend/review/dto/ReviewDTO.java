package dine.dineshotbackend.review.dto;

import dine.dineshotbackend.store.dto.RestaurantDTO;
import dine.dineshotbackend.user.entity.User;
import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor@Setter@Getter@ToString
public class ReviewDTO {
    private Long reviewCode;
    private boolean reviewIsOpen;
    private Date reviewRegisterDate;
    private User userCode;
    private float reviewRate;

    //리뷰 작성 시 받아와야 함.
    private RestaurantDTO restaurantCode;
    private List<ReviewTagDTO> tag;
    private String reviewDetail;
    private List<ReviewImageDTO> image;
}
