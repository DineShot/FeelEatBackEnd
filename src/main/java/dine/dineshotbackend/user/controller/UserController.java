package dine.dineshotbackend.user.controller;

import dine.dineshotbackend.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
        userService.getUserInformation(userName,reviewCount,badgeName);
        return null;
    }
}
