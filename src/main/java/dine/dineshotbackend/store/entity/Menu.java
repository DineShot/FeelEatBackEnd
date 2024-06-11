package dine.dineshotbackend.store.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity@Table(name = "menu")
@AllArgsConstructor@NoArgsConstructor@Getter@Setter@ToString
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_code")
    private Long menuCode;
    @Column(name = "menu_name")
    private String menuName;
    @Column(name = "menu_photo_change")
    private String menuPhotoChange;
    @Column(name = "menu_explain")
    private String menuExplain;
    @Column(name = "menu_is_sell")
    private boolean menuIsSell;
    @Column(name = "menu_is_adult")
    private boolean menuIsAdult;
    @Column(name = "menu_discount_rate")
    private Integer menuDiscountRate;
    @Column(name = "menu_price")
    private Integer menuPrice;

    @Column(name = "restaurant_code")
    private Long restaurant;
}
