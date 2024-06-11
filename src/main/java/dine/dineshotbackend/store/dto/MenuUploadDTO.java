package dine.dineshotbackend.store.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class MenuUploadDTO {
    private Long menuCode; // Entity에서 자동생성 될거
    private String menuName;
    private String menuExplain;
    private boolean menuIsSell; // 팔고있는지
    private boolean menuIsAdult; // 성인전용 메뉴
    private Integer menuDiscountRate; // 할인율
    private Integer menuPrice; // 메뉴 가격

}
