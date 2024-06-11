package dine.dineshotbackend.security.join;

import dine.dineshotbackend.common.response.ResponseDTO;
import dine.dineshotbackend.common.response.ResponseTool;
import dine.dineshotbackend.user.dto.UserJoinDTO;
import dine.dineshotbackend.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class JoinController {
    private final UserService userService;
    private final ResponseTool tool;

    public JoinController(UserService userService, ResponseTool tool) {
        this.userService = userService;
        this.tool = tool;

    }

    @PostMapping("/join") // 회원가입 메서드
    public ResponseEntity<ResponseDTO> joinUserIfNotExist(UserJoinDTO dto){
        if(userService.joinUser(dto)){
            return tool.res("회원가입이 완료되었습니다.",null);
        }else {
            return tool.resErr(HttpStatus.BAD_REQUEST,"이미 존재하는 회원이거나 카카오 로그인이 실패했습니다.");

        }
    }
}
