package dine.dineshotbackend.follow.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "follow")
@Getter
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "follow_code")
    private Long followCode;

    @Column(name = "follow_to")
    private Long followTo;

    @Column(name = "follow_by")
    private Long followBy;
}
