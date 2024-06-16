package dine.dineshotbackend.store.controller;

import dine.dineshotbackend.common.response.ResponseDTO;
import dine.dineshotbackend.common.response.ResponseTool;
import dine.dineshotbackend.security.dto.CustomUserDetails;
import dine.dineshotbackend.store.dto.*;
import dine.dineshotbackend.store.service.StoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "가게",description = "가게 관련 API입니다.")
@RestController
@RequestMapping("/store")
public class StoreController {

    private final StoreService storeService;
    private final ResponseTool tool;

    public StoreController(StoreService storeService, ResponseTool tool) {
        this.storeService = storeService;
        this.tool = tool;
    }

    /**
     * 가게의 이미지를 서버에 저장하고, DB에 insert 하는 메서드
     *
     * @param files          Form 파일들
     * @param restaurantCode 가게 코드
     * @return 응답
     */
    @PostMapping("/upload-restaurant-image/{restaurantCode}")
    public ResponseEntity<ResponseDTO> imgUpload(@RequestPart ArrayList<MultipartFile> files, @PathVariable(name = "restaurantCode") Long restaurantCode) {
        try {
            for (MultipartFile file : files) {
                if (file.isEmpty()) {
                    tool.resErr(HttpStatus.BAD_REQUEST, "파일이 비어있습니다.");
                }
            }
            List<RestaurantImageDTO> restaurantImage = storeService.imgUpload(files, restaurantCode);
            if (restaurantImage == null) {
                tool.resErr(HttpStatus.BAD_REQUEST, "파일을 저장하는 중 에러가 발생했습니다.");
            }
            return tool.res("성공", restaurantImage);
        } catch (Exception e) {
            return tool.resErr(HttpStatus.BAD_REQUEST, "에러가 발생했습니다.\n" + e);
        }
    }

    /**
     * @param restaurantJoinDTO 가게의 데이터들
     * @return 성공시 200
     */
    @PostMapping("/uploadstore")
    public ResponseEntity<ResponseDTO> createStore(RestaurantJoinDTO restaurantJoinDTO, @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        //가게 사장님들만 접근 가능한 메서드여야함 (나중에 수정)
        Long userCode = customUserDetails.getAccountCode();
        System.out.println("userCode = " + userCode);
        if (!storeService.insertRestaurant(restaurantJoinDTO, userCode)) {
            return tool.resErr(HttpStatus.BAD_REQUEST, "가게를 등록하는중 오류가 발생하였습니다.");
        }
        return tool.res("성공적으로 가게가 등록되었습니다.", HttpStatus.OK);
    }

    @GetMapping("/showMenu") // 레스토랑 코드로 메뉴 조회 리스트
    public ResponseEntity<?> getMenuList(@RequestParam Long restaurantCode) {
        List<MenuListDTO> menuList = storeService.getMenuList(restaurantCode);
        return ResponseEntity.ok().body(menuList);
    }

    @GetMapping("/deleteMenu")
    public ResponseEntity<String> deleteMenu(@RequestParam Long menuCode) {
        storeService.deleteMenu(menuCode);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/searchedRestaurant")
    public ResponseEntity<?> findRestaurantList(RestaurantFindFilterDTO filterDTO) {
        return ResponseEntity.ok().body(storeService.findRestaurantWithFileter(filterDTO)); // DTO로 변환필요
    }

    @Operation(summary = "가까운 가게 검색",description = "사용자 현재 위치 주변 가게 검색기능")
    @ApiResponse(responseCode = "200",description = "가게들의 정보를 담은 DTO 의 List 를 반환합니다."
    ,content = @Content(schema = @Schema(implementation = NearRestaurantResponseDTO.class),mediaType = "application/json"))
    @GetMapping("/nearRestaurant")
    public ResponseEntity<?> findNearRestaurant(@Parameter(description = "위도,경도,거리 세가지 전부 필수") NearRestaurantFindDTO dto){
        return ResponseEntity.ok().body(storeService.findNearRestaurantList(dto));
    }
}
