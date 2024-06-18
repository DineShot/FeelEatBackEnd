package dine.dineshotbackend.badge.repository;

import dine.dineshotbackend.badge.entity.Badge;
import dine.dineshotbackend.queryDSL.CustomBadgeRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BadgeRepository extends JpaRepository<Badge,Long>, CustomBadgeRepository {

}
