package dine.dineshotbackend.user.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserJoinDTO {
    private Long userCode;
    private String userName;
    private boolean isCeo;
    private String userProfileImg;
    private String userRole;
    private String userAddress;
    private String kakaoToken;
}
