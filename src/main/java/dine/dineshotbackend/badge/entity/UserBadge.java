package dine.dineshotbackend.badge.entity;

import dine.dineshotbackend.user.entity.User;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@IdClass(UserBadgeId.class)
public class UserBadge {
    @Id
    @ManyToOne
    @JoinColumn(name = "badge_code")
    private Badge badgeCode;

    @Id
    @ManyToOne
    @JoinColumn(name = "user_code")
    private User userCode;

    @Column(name = "user_badge_get_date")
    private Date badgeDate;
}
