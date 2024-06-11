package dine.dineshotbackend.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    public User(Long userCode) {
        this.userCode = userCode;
    }

    public String getAccountPassword(){
        return null;
    }

}
