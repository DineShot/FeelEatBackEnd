package dine.dineshotbackend.store.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity@Table(name = "restaurant_image")
@AllArgsConstructor@NoArgsConstructor@Getter@Setter
public class RestaurantImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_image_code")
    private Long restaurantImageCode;
    @Column(name = "restaurant_image_original")
    private String restaurantImageOriginal;
    @Column(name = "restaurant_image_change")
    private String restaurantImageChange;
    @Column(name = "restaurant_image_file_path")
    private String restaurantImageFilePath;
    @Column(name = "restaurant_image_is_delete")
    private boolean restaurantImageIsDelete;
    @Column(name = "restaurant_code")
    private Long restaurant;
}
