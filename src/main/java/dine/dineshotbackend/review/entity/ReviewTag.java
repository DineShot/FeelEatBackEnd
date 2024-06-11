package dine.dineshotbackend.review.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "review_tag")
@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
public class ReviewTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_tag_code")
    private Long reviewTagCode;

    @Column(name = "review_tag_name")
    private String reviewTagName;

    @JoinColumn(name = "review_code")
    private Long reviewCode;
}
