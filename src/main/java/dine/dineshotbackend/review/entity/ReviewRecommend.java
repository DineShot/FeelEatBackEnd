package dine.dineshotbackend.review.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dine.dineshotbackend.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@IdClass(ReviewReCommendId.class)
@Table(name = "review_recommend")
@Getter
@Setter
public class ReviewRecommend {
    @Id
    @ManyToOne
    @JoinColumn(name = "review_code")
    @JsonIgnore
    private Review reviewCode;

    @Id
    @ManyToOne
    @JoinColumn(name = "user_code")
    private User userCode;

    @Column(name = "review_recommend_date")
    private LocalDate reviewRecommendDate;
}
