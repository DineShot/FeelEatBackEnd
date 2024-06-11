package dine.dineshotbackend.review.repository;

import dine.dineshotbackend.review.entity.Review;
import dine.dineshotbackend.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findByUserCodeInAndReviewIsOpenTrueOrderByReviewRegisterDateDesc(List<User> followingUser, Pageable pageable);
    @Query(value = "UPDATE review SET review_isopen = false WHERE review_code = ?", nativeQuery = true)
    void deleteReview(Long reviewCode);
}
