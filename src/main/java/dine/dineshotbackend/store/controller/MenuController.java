package dine.dineshotbackend.store.controller;

import dine.dineshotbackend.common.response.ResponseDTO;
import dine.dineshotbackend.common.response.ResponseTool;
import dine.dineshotbackend.store.dto.MenuUploadDTO;
import dine.dineshotbackend.store.service.MenuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/menu")
public class MenuController {
    private final MenuService menuService;
    private final ResponseTool tool;

    public MenuController(MenuService menuService, ResponseTool tool) {
        this.menuService = menuService;
        this.tool = tool;
    }

    /**
     * @param restaurantCode 가게 고유 코드 (프론트에서 받아와야함)
     * @param menuUploadDTO  메뉴에 대한 정보들
     * @param file           메뉴 사진
     * @return 성공시 200
     */
    @PostMapping("/uploadmenu") // 메뉴 업로드하는 메서드
    public ResponseEntity<ResponseDTO> uploadMenu(@RequestParam("restaurantCode") Long restaurantCode, @ModelAttribute MenuUploadDTO menuUploadDTO, @RequestPart("file") MultipartFile file) {
        if (menuService.addMenu(restaurantCode, menuUploadDTO, file)) {
            return tool.res("성공적으로 메뉴가 업로드 되었습니다.", null);
        }
        ;
        return tool.resErr(HttpStatus.BAD_REQUEST, "메뉴 업로드 과정중 오류가 발생하였습니다.");
    }

}
