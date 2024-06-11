package dine.dineshotbackend.review.repository;

import dine.dineshotbackend.review.entity.Review;
import dine.dineshotbackend.review.entity.ReviewRecommend;
import dine.dineshotbackend.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReviewRecommendRepository extends JpaRepository<ReviewRecommend, Long> {
    List<ReviewRecommend> findByReviewRecommendDate(LocalDate today);
    boolean existsByUserCodeAndReviewCode(User user, Review review);
    void deleteByUserCodeAndReviewCode(User user, Review review);
}
