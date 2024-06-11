package dine.dineshotbackend.review.repository;

import dine.dineshotbackend.review.entity.ReviewTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewTagRepository extends JpaRepository<ReviewTag, Long> {
}
