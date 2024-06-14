package dine.dineshotbackend.user.controller;

import dine.dineshotbackend.user.dto.UserFindDTO;
import dine.dineshotbackend.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    @Operation(
            summary = "유저를 조건에 따라 찾을 수 있는 메서드",
            description = "userCode, reviewCount, badgeName 중 1개를 사용하여 유저를 찾을 수 있다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "찾은 유저 List를 반환",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = String.class),
                                    examples = @ExampleObject(value = "{userCode: 1, userIsCeo: false, userName:'임시', userProfileImage:'ssajceip2vji3.png'}")
                            )
                    ),
                    @ApiResponse(responseCode = "500", description = "에러 내용 + 의 오류로 실패했습니다.")
            }
    )
    public ResponseEntity<?> getUserInformation(@RequestParam(required = false) String userName,
                                                @RequestParam(required = false) Integer reviewCount,
                                                @RequestParam(required = false) String badgeName
    ){
        try{
            List<UserFindDTO> user =  userService.getUserInformation(userName,reviewCount,badgeName);
            if(user.isEmpty()){
                return ResponseEntity.ok().body("아무도 없습니다.");
            }
            return ResponseEntity.ok().body(user);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage()+"의 오류로 실패했습니다.");
        }
    }
}
