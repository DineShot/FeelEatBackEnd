package dine.dineshotbackend.user.repository;

import dine.dineshotbackend.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUserCodeIn(List<Long> following);


    @Query(value = "SELECT * FROM user JOIN (SELECT user_code FROM review GROUP BY user_code HAVING COUNT(*) >= 2) r ON user.user_code = r.user_code",nativeQuery = true)
    List<User> selectUserByReviewCount();
}
