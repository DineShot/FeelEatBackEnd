package dine.dineshotbackend.review.controller;

import dine.dineshotbackend.common.response.ResponseDTO;
import dine.dineshotbackend.common.response.ResponseTool;
import dine.dineshotbackend.review.dto.ReviewSearchFilterDTO;
import dine.dineshotbackend.review.dto.ReviewSearchResponseDTO;
import dine.dineshotbackend.review.dto.ReviewWriteDTO;
import dine.dineshotbackend.review.service.ReviewService;
import dine.dineshotbackend.user.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static dine.dineshotbackend.common.tools.Tool.imageUpload;

@Tag(name = "리뷰",description = "리뷰관련 API 입니다.")
@RestController
public class ReviewController {
    private final ReviewService reviewService;
    private final ResponseTool tool;

    public ReviewController(ReviewService reviewService, ResponseTool tool) {
        this.reviewService = reviewService;
        this.tool = tool;
    }

    /**
     * 리뷰 작성 메서드
     *
     * @param review reviewCode, reviewDetail, tags:["",...],images:["",...]
     * @return success: 200, fail: 400
     */
    @PostMapping("/review")
    public ResponseEntity<?> writeReview(@RequestBody ReviewWriteDTO review){
        String check = reviewService.writeReview(review);
        if(check.equals("success")){
            return ResponseEntity.ok().body("리뷰 등록에 성공했습니다.");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(check+"의 에러로 실패했습니다.");
        }
    }

    /**
     * 리뷰 쓰기 시 이미지를 업로드했을 때 호출하는 메서드
     *
     * @param file 폼데이터 파일
     * @return 변경된 파일 이름
     */
    @PostMapping("/image")
    public ResponseEntity<?> uploadImg(MultipartFile file) {
        String changedFileName = imageUpload(file);
        if (changedFileName == null) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok().body(changedFileName);
    }
    @PutMapping("/review")
    public ResponseEntity<ResponseDTO> deleteReview(@RequestParam Long reviewCode){
        reviewService.deleteReview(reviewCode);
        return tool.res("리뷰 삭제에 성공했습니다.", null);
    }

    //지역별로 리뷰를 받아보자
    @GetMapping("/review/home")
    public ResponseEntity<ResponseDTO> showHomeReview(@RequestParam(value = "page")int page){
        Long userCode = 1L; //임시 유저 코드
        Object reviews = reviewService.showHomeReview(page, userCode);
        if (reviews == null) {
            return tool.resErr(HttpStatus.BAD_REQUEST, "팔로우 한 사람이 없거나(에러 처리 예정), 리뷰가 없음");
        }
        return tool.res("리뷰 가져오기 성공", reviews);
    }
    @PostMapping("/review-recommend")
    public ResponseEntity<ResponseDTO> reviewRecommend(@RequestParam Long reviewCode){
        User user = new User();
        user.setUserCode(1L);
        if (reviewService.reviewRecommend(reviewCode, user)) {
            return tool.res("추천", null);
        } else {
            return tool.res("추천 취소", null);
        }
    }


    @Operation(summary = "사용자 주변 리뷰검색",description = "사용자 주변 가게 리뷰검색 메서드입니다.")
    @ApiResponse(responseCode = "200",description = "요청 성공, 리뷰 ResponseDTO 들을 JSON 으로 반환",
    content = @Content(schema = @Schema(implementation = ReviewSearchResponseDTO.class)))
    @GetMapping("/searchedReviews")
    public ResponseEntity<?> findReviewWithFilter (@Parameter(description = "리뷰검색을 위한 객체 latitude,longitude,radius 만 필수값") ReviewSearchFilterDTO fileterDTO) {
        return ResponseEntity.ok().body(reviewService.searchReviewWithFilter(fileterDTO));
    }
}

