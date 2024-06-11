package dine.dineshotbackend.badge.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "badge")
public class Badge {
    @Id
    @Column(name = "badge_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long badgeCode;

    @Column(name = "badge_image_name")
    private String badgeImageName;

    @Column(name = "badge_howtoget")
    private String badgeHowToGet;
}
