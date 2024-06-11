package dine.dineshotbackend.review.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "review_image")
@Getter
@Setter
public class ReviewImage {
    @Id
    @Column(name = "review_image_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewImageCode;

//    @ManyToOne
    @Column(name = "review_code")
    private Long reviewCode;

    @Column(name = "review_image_original")
    private String reviewImageOriginal;

    @Column(name = "review_image_change")
    private String reviewImageChange;
}
