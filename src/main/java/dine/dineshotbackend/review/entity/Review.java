package dine.dineshotbackend.review.entity;

import dine.dineshotbackend.store.entity.Restaurant;
import dine.dineshotbackend.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "review")
@Getter
@Setter
@ToString
public class Review {
    @Id
    @Column(name = "review_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewCode;

    @Column(name = "review_detail")
    private String reviewDetail;

    @Column(name = "review_isopen")
    private boolean reviewIsOpen;

    @Column(name = "review_registerdate")
    private Date reviewRegisterDate;

    @ManyToOne
    @JoinColumn(name = "user_code")
    private User userCode;

    @Column(name = "review_recommend_count")
    private Long recommendCount;

    //가게 코드
    //가게 정보, 가게 이미지, 가게 메뉴
    @ManyToOne
    @JoinColumn(name = "restaurant_code")
    private Restaurant restaurantCode;
    //리뷰 이미지
    @OneToMany(mappedBy = "reviewCode")
    private List<ReviewImage> image;
    //리뷰 태그
    @OneToMany(mappedBy = "reviewCode")
    private List<ReviewTag> tag;
    @OneToMany(mappedBy = "reviewCode")
    private List<ReviewRecommend> reviewRecommend;

    //좋아요 갯수 추가 / 감소
    public void increaseRecommendCount() {
        this.recommendCount++;
    }
    public void decreaseRecommendCount() {
        this.recommendCount--;
    }
    @OneToMany(mappedBy = "reviewCode")
    private List<ReviewMenu> reviewMenu;
}
