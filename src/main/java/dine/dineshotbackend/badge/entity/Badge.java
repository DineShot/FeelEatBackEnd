package dine.dineshotbackend.badge.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "badge")
public class Badge {
    @Id
    @Column(name = "badge_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long badgeCode;

    @Column(name = "badge_image_name")
    private String badgeImageName;

    @Column(name = "badge_name")
    private String badgeName;

    @Column(name = "badge_explain")
    private String badgeExplain;

    @Column(name = "badge_level")
    @Enumerated(EnumType.STRING)
    private BadgeLevel badgeLevel;

    @Column(name = "badge_category")
    @Enumerated(EnumType.STRING)
    private BadgeCategory badgeCategory;

    @Column(name = "badge_has_user_count")
    private int badgeHasUserCount;

    /**
    뱃지를 가지고 있는 유저수를 뱃지에 저장 -> 서비스단에서 사용할때 이 메서드 호출후 다시 save() 해야함
     */
    public void increaseBadgeHasUserCount() {
        this.badgeHasUserCount++;
    };
    public void decreaseBadgeHasUsercount(){
        this.badgeHasUserCount--;
    }
}
