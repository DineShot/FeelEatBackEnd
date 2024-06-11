package dine.dineshotbackend.queryDSL;

import dine.dineshotbackend.review.dto.ReviewSearchFilterDTO;
import dine.dineshotbackend.review.entity.Review;

import java.util.List;

public interface CustomReviewRepository {
    List<Review> findAllReviewWithFilter(ReviewSearchFilterDTO DTO);
}
