package dine.dineshotbackend.queryDSL;

import dine.dineshotbackend.badge.dto.BadgeFindFilterDTO;
import dine.dineshotbackend.badge.entity.Badge;

import java.util.List;

public interface CustomBadgeRepository {
    List<Badge> findBadgeByFilter(BadgeFindFilterDTO DTO);
}
