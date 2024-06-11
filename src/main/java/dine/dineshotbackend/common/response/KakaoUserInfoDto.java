package dine.dineshotbackend.common.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class KakaoUserInfoDto {
    public Long id;
    public String userName;
    public String profileImageUrl;
    public String thumbImageUrl;

    @Builder
    public KakaoUserInfoDto(Long id, String userName, String profileImageUrl, String thumbImageUrl) {
        this.id = id;
        this.userName = userName;
        this.profileImageUrl = profileImageUrl;
        this.thumbImageUrl = thumbImageUrl;
    }
}
