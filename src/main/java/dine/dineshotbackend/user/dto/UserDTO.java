package dine.dineshotbackend.user.dto;
import lombok.*;
@AllArgsConstructor@NoArgsConstructor@Getter@Setter@ToString
public class UserDTO {
    private Long userCode;
    private String userName;
    private boolean userIsCEO;
    private String userProfileImg;
}
