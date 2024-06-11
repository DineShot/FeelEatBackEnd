package dine.dineshotbackend.common.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseTool {
    /**
     * 정상적인 응답
     * @param msg 성공 메세지
     * @param data 클라이언트로 보낼 데이터
     * @return ResponseEntity 로 변환하여 return
     */
    public ResponseEntity<ResponseDTO> res(String msg, Object data){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,msg,data));
    }

    /**
     * 에러를 응답
     * @param status HttpStatus.x 객체
     * @param msg 응답 메세지
     * @return ResponseEntity 로 변환하여 return, data 는 null 이다.
     */
    public ResponseEntity<ResponseDTO> resErr(HttpStatus status, String msg){
        return ResponseEntity.ok().body(new ResponseDTO(status,msg,null));
    }
}
