package dine.dineshotbackend.review.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dine.dineshotbackend.store.entity.Menu;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "review_menu")
@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
public class ReviewMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_menu_code")
    private Long reviewMenuCode;
    @JoinColumn(name = "review_code")
    @ManyToOne
    @JsonIgnore
    private Review reviewCode;
    @JoinColumn(name = "menu_code")
    @ManyToOne
    private Menu menuCode;
}
