package dine.dineshotbackend.store.repository;

import dine.dineshotbackend.store.entity.RestaurantImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantImageRepository extends JpaRepository<RestaurantImage, Long> {
}
