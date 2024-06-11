package dine.dineshotbackend.follow.repository;


import dine.dineshotbackend.follow.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    List<Follow> findByFollowBy(Long userCode);
}
