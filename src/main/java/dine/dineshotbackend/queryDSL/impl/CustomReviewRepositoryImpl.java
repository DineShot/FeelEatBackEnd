package dine.dineshotbackend.queryDSL.impl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import dine.dineshotbackend.queryDSL.CustomReviewRepository;
import dine.dineshotbackend.review.dto.ReviewSearchFilterDTO;
import dine.dineshotbackend.review.entity.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;
import static dine.dineshotbackend.review.entity.QReview.review;
import static dine.dineshotbackend.store.entity.QRestaurant.restaurant;

@Repository
@RequiredArgsConstructor
public class CustomReviewRepositoryImpl implements CustomReviewRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override // 필터를 통한 리뷰 검색
    public List<Review> findAllReviewWithFilter(ReviewSearchFilterDTO DTO) {

        return jpaQueryFactory.selectFrom(review)
                .join(review.restaurantCode,restaurant)
                .where(nearReview(DTO))
                .fetch();
    }

    private BooleanExpression nearReview(ReviewSearchFilterDTO dto) {
        double lat1 = dto.getLatitude();
        double lon1 = dto.getLongitude();
        double radius = dto.getRadius(); // 반경 (킬로미터 단위)
        System.out.println("dto = " + dto);

        // 하버사인 공식을 사용하여 두 지점 간의 거리를 계산하는 SQL 표현식
        NumberExpression<Double> distance = Expressions.numberTemplate(Double.class,
                "6371 * acos(cos(radians({0})) * cos(radians({1})) * cos(radians({2}) - radians({3})) + sin(radians({0})) * sin(radians({1})))",
                lat1, restaurant.restaurantLatitude, restaurant.restaurantLongitude, lon1);

        // 반경 이내의 장소 필터링 (loe = less than or equal to = 이하)
        return distance.loe(radius);
    }
}
