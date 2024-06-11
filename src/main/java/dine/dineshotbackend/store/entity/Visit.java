package dine.dineshotbackend.store.entity;

import dine.dineshotbackend.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity@Table(name = "visit")
@AllArgsConstructor@NoArgsConstructor@Getter@Setter
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "visit_code")
    private Long visitCode;
    @Column(name = "visit_time")
    private String visitTime;

    @ManyToOne
    @JoinColumn(name = "user_code")
    private User UserCode;

    @ManyToOne
    @JoinColumn(name = "restaurant_code")
    private Restaurant restaurantCode;
}
