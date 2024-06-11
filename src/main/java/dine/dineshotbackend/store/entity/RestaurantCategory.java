package dine.dineshotbackend.store.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "restaurant_category")
public class RestaurantCategory {
    @Id
    @Column(name = "restaurant_category_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurantCategoryCode;

    @Column(name = "restaurant_category_name")
    private String restaurantCategoryName;

    @Column(name = "restaurant_code")
    private Long restaurantCode;
}
