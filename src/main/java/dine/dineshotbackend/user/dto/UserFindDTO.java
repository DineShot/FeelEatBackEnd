package dine.dineshotbackend.user.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter@Getter@ToString
public class UserFindDTO {
    private Long userCode;
    private boolean userIsCeo;
    private String userName;
    private String userProfileImage;
}
