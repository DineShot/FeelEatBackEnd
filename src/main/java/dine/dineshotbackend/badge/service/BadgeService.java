package dine.dineshotbackend.badge.service;

import dine.dineshotbackend.badge.dto.BadgeFindFilterDTO;
import dine.dineshotbackend.badge.entity.Badge;
import dine.dineshotbackend.badge.repository.BadgeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BadgeService {
    private final BadgeRepository badgeRepository;

    public BadgeService(BadgeRepository badgeRepository) {
        this.badgeRepository = badgeRepository;
    }

    /**
     * 뱃지 갖고 있는 유저수 ++
     */
    @Transactional
    public void increaseBadgeHasUserCount(Long badgeCode) {
        Optional<Badge> badge = badgeRepository.findById(badgeCode);
        if (badge.isEmpty()) {
            throw new IllegalArgumentException("Badge not found");
        }
        Badge newBadge = badge.get();
        newBadge.increaseBadgeHasUserCount();
        badgeRepository.save(newBadge);
    }

    /**
     * 뱃지 갖고 있는 유저수 --
     */
    @Transactional
    public void decreaseBadgeHasUserCount(Long badgeCode) {
        Optional<Badge> badge = badgeRepository.findById(badgeCode);
        if (badge.isEmpty()) {
            throw new IllegalArgumentException("Badge not found");
        }
        Badge newBadge = badge.get();
        newBadge.decreaseBadgeHasUsercount();
        badgeRepository.save(newBadge);
    }

    public List<Badge> findBadgesWithFilter(String name,String category,String level) {
        BadgeFindFilterDTO dto = BadgeFindFilterDTO.builder()
                .badgeName(name)
                .badgeCategory(category)
                .badgeLevel(level)
                .build();
        return badgeRepository.findBadgeByFilter(dto);
    }
}
