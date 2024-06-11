package dine.dineshotbackend.user.controller;

import dine.dineshotbackend.user.dto.UserFindDTO;
import dine.dineshotbackend.user.service.UserService;
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
    public ResponseEntity<?> getUserInformation(@RequestParam(required = false) String userName,
                                                @RequestParam(required = false) Integer reviewCount,
                                                @RequestParam(required = false) String badgeName
    ){
        try{
            List<UserFindDTO> user =  userService.getUserInformation(userName,reviewCount,badgeName);
            return ResponseEntity.ok().body(user);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage()+"의 오류로 실패했습니다.");
        }
    }
}
