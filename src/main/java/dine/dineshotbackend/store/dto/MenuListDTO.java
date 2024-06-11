package dine.dineshotbackend.store.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MenuListDTO {
    private String menuName;
    private String menuImgChangedName;
    private int menuPrice;
    private String menuExplain;
}
