package dine.dineshotbackend.review.entity;

import dine.dineshotbackend.user.entity.User;
import jakarta.persistence.*;

@Entity
@IdClass(ComplainId.class)
@Table(name = "complain")
public class Complain {
    @Id
    @ManyToOne
    @JoinColumn(name = "review_code")
    private Review reviewCode;

    @Id
    @ManyToOne
    @JoinColumn(name = "user_code")
    private User userCode;

}

