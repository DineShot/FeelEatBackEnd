package dine.dineshotbackend.badge.entity;

import dine.dineshotbackend.review.entity.ComplainId;
import dine.dineshotbackend.user.entity.User;
import jakarta.persistence.*;

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

}
