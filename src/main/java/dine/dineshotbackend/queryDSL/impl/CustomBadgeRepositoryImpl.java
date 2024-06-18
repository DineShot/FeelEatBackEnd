package dine.dineshotbackend.queryDSL.impl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import dine.dineshotbackend.badge.dto.BadgeFindFilterDTO;
import dine.dineshotbackend.badge.entity.Badge;
import dine.dineshotbackend.badge.entity.BadgeCategory;
import dine.dineshotbackend.badge.entity.BadgeLevel;
import dine.dineshotbackend.queryDSL.CustomBadgeRepository;
import static dine.dineshotbackend.badge.entity.QBadge.badge;

import java.util.List;

public class CustomBadgeRepositoryImpl implements CustomBadgeRepository {
    private final JPAQueryFactory queryFactory;

    public CustomBadgeRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }


    /**
     * 필터를 이용한 뱃지 검색
     */
    @Override
    public List<Badge> findBadgeByFilter(BadgeFindFilterDTO DTO) {
        return queryFactory.selectFrom(badge)
                .where(findByName(DTO.getBadgeName()),
                        findByBadgeLevel(DTO.getBadgeLevel()),
                        findByCategory(DTO.getBadgeCategory()))
                .fetch();
    }

    private BooleanExpression findByCategory(String category) {
        if (category == null) {
            return null;
        }
        return badge.badgeCategory.eq(BadgeCategory.valueOf(category.toUpperCase()));
    }

    private BooleanExpression findByBadgeLevel(String badgeLevel) {
        if (badgeLevel == null) {
            return null;
        }
        return badge.badgeLevel.eq(BadgeLevel.valueOf(badgeLevel.toUpperCase()));
    }
    private BooleanExpression findByName(String name) {
        if (name == null) {
            return null;
        }
        return badge.badgeName.contains(name);
    }
}
