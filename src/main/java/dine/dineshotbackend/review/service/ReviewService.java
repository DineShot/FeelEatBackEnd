package dine.dineshotbackend.review.service;

import dine.dineshotbackend.common.tools.Tool;
import dine.dineshotbackend.follow.entity.Follow;
import dine.dineshotbackend.follow.repository.FollowRepository;
import dine.dineshotbackend.review.dto.ReviewWriteDTO;
import dine.dineshotbackend.review.entity.Review;
import dine.dineshotbackend.review.entity.ReviewImage;
import dine.dineshotbackend.review.entity.ReviewRecommend;
import dine.dineshotbackend.review.entity.ReviewTag;
import dine.dineshotbackend.review.repository.ReviewImageRepository;
import dine.dineshotbackend.review.repository.ReviewRecommendRepository;
import dine.dineshotbackend.review.repository.ReviewRepository;
import dine.dineshotbackend.review.repository.ReviewTagRepository;
import dine.dineshotbackend.store.entity.Restaurant;
import dine.dineshotbackend.user.entity.User;
import dine.dineshotbackend.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ModelMapper mapper;
    private final FollowRepository followRepository;
    private final UserRepository userRepository;
    private final ReviewRecommendRepository reviewRecommendRepository;
    private final Tool tool;
    private final ReviewTagRepository reviewTagRepository;
    private final ReviewImageRepository reviewImageRepository;

    public ReviewService(ReviewRepository reviewRepository, ModelMapper mapper, FollowRepository followRepository, UserRepository userRepository, ReviewRecommendRepository reviewRecommendRepository, Tool tool, ReviewTagRepository reviewTagRepository, ReviewImageRepository reviewImageRepository) {
        this.reviewRepository = reviewRepository;
        this.mapper = mapper;
        this.followRepository = followRepository;
        this.userRepository = userRepository;
        this.reviewRecommendRepository = reviewRecommendRepository;
        this.tool = tool;
        this.reviewTagRepository = reviewTagRepository;
        this.reviewImageRepository = reviewImageRepository;
    }
    //음식점 : 이름, 주소,상세주소, 설명

    //리뷰 : 리뷰어가 먹은 메뉴
    //유저, 이미지

    //리뷰 조회하는거 리뷰 조회할건데 자신이 팔로우한 사람의 리뷰를 조회해야함
    //만약 팔로우한 사람이 없다면 가장 인기있는 리뷰를 조회해야함
    public Object showHomeReview(int page,Long userCode) {
        Pageable pageable = PageRequest.of(page, 5);
        //1.
        //- 팔로우한 사람의 유저 코드를 가져오자
        List<Follow> follows = followRepository.findByFollowBy(userCode);
        List<Long> following = new ArrayList<>();
        for (Follow follow : follows) {
            following.add(follow.getFollowTo());
        }
        List<User> followingUser = userRepository.findByUserCodeIn(following);
        //- 팔로우한 유저 코드를 갖고 있는 리뷰 열을 찾자.
        Page<Review> reviews = reviewRepository.findByUserCodeInAndReviewIsOpenTrueOrderByReviewRegisterDateDesc(followingUser,pageable);
        //- 아무 것도 없다면 2번으로
        if(!reviews.isEmpty()){
            //- 있다면 시간을 현재 날짜와 가까운 순으로 정렬하여 가져오자
            return reviews;
        }
        //2.
        //- 사용자의 현재 지역에서  <- 이거 DB에 없네
        else {
            //- 당일 추천이 가장 많은 순으로 리뷰를 가져온다.
            System.out.println("팔로잉 없음");
            LocalDate today = LocalDate.now();
            List<ReviewRecommend> recommends = reviewRecommendRepository.findByReviewRecommendDate(today);
            List<Review> reviews1 =  recommends.stream()
                    .map(ReviewRecommend::getReviewCode).toList();  //음.. 이러면 페이징이 안되는데 return 불가능
            for(Review review : reviews1){
                System.out.println(review.getReviewDetail());
            }
            return reviews1;
        }
    }


    @Transactional
    public String writeReview(ReviewWriteDTO review){
        try{
            Review reviewEntity = new Review();
            reviewEntity.setUserCode(new User(1L));
            reviewEntity.setReviewDetail(review.getReviewDetail());
            reviewEntity.setReviewIsOpen(true);
            reviewEntity.setReviewRegisterDate(new Date());
            reviewEntity.setRestaurantCode(new Restaurant(review.getRestaurantCode()));
            reviewEntity.setRecommendCount(0L);
            reviewEntity = reviewRepository.save(reviewEntity);

            List<ReviewTag> reviewTags = new ArrayList<>();
            for(String tag : review.getTags()){
                ReviewTag reviewTag = new ReviewTag();
                reviewTag.setReviewCode(reviewEntity.getReviewCode());
                reviewTag.setReviewTagName(tag);
                reviewTags.add(reviewTag);
            }
            reviewTagRepository.saveAll(reviewTags);
            List<ReviewImage> reviewImages = new ArrayList<>();
            for(String image : review.getImages()){
                ReviewImage reviewImage = new ReviewImage();
                reviewImage.setReviewCode(reviewEntity.getReviewCode());
                reviewImage.setReviewImageChange(image);
                reviewImages.add(reviewImage);
            }
            reviewImageRepository.saveAll(reviewImages);
            return "success";
        } catch (Exception e){
            System.out.println(e.getMessage());
            return e.getMessage();
        }

    }
    public void deleteReview(Long reviewCode) {
        reviewRepository.deleteReview(reviewCode);
    }

    @Transactional
    public boolean reviewRecommend(Long reviewCode,User user) {
        try {
            Review review = reviewRepository.findById(reviewCode).get();

            if (reviewRecommendRepository.existsByUserCodeAndReviewCode(user, review)) {
                //이미 추천을 했음.
                reviewRecommendRepository.deleteByUserCodeAndReviewCode(user, review);
                review.decreaseRecommendCount(); // 좋아요 1 감소
                return true;
            } else {
                //추천이 안되어 있음.
                ReviewRecommend reviewRecommendEntity = new ReviewRecommend();
                reviewRecommendEntity.setReviewRecommendDate(LocalDate.now());
                reviewRecommendEntity.setUserCode(user);
                reviewRecommendRepository.save(reviewRecommendEntity);
                review.increaseRecommendCount(); // 좋아요 1 증가
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
}