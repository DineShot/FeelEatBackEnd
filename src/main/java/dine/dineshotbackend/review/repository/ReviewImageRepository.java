package dine.dineshotbackend.review.repository;

import dine.dineshotbackend.review.entity.ReviewImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewImageRepository extends JpaRepository<ReviewImage, Long> {
}
