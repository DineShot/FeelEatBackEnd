package dine.dineshotbackend.user.repository;

import dine.dineshotbackend.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUserCodeIn(List<Long> following);

    @Query(value = "SELECT user.* FROM user JOIN user_badge ON user.user_code = user_badge.user_code JOIN badge ON user_badge.badge_code = badge.badge_code WHERE badge.badge_name LIKE CONCAT('%',:badgeName,'%')", nativeQuery = true)
    List<User> selectUserByBadge(String badgeName);
    @Query(value = "SELECT user.* FROM user JOIN (SELECT user_code FROM review GROUP BY user_code HAVING COUNT(*) >= :reviewCount) r ON user.user_code = r.user_code",nativeQuery = true)
    List<User> selectUserByReviewCount(int reviewCount);
    List<User> findAllByUserNameContaining(String userName);
}
