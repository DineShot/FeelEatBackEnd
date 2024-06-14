package dine.dineshotbackend.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Entity
@AllArgsConstructor@NoArgsConstructor@Getter@Setter
@Table(name = "user")
public class User {
    @Id
    @Column(name = "user_code")
    private Long userCode;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_isceo")
    private boolean userIsCEO;
    @Column(name = "user_profile_img")
    private String userProfileImg;
    @Column(name = "user_address")
    private String userAddress;
    @Column(name = "user_role")
    private String userRole;
    @Column(name = "user_follwer_count")
    private int userFollwerCount;

    public User(Long userCode) {
        this.userCode = userCode;
    }

    //팔로워 수 추가 감소 메서드
    public void increaseUserFollwerCount() {
        this.userFollwerCount++;
    }
    public void decreaseUserFollwerCount() {
        this.userFollwerCount--;
    }

    public String getAccountPassword(){
        return null;
    }

}
