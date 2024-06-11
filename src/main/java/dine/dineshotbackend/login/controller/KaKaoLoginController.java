package dine.dineshotbackend.login.controller;

import dine.dineshotbackend.common.response.KakaoUserInfoDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/kakao")
public class KaKaoLoginController {

    @GetMapping("/test") // 테스트용 메서드
    public void getUserInfoTest(HttpServletRequest request){
        System.out.println(" userId = " + request.getAttribute("userId"));
        System.out.println("userName = " + request.getAttribute("userName"));


    }
}
