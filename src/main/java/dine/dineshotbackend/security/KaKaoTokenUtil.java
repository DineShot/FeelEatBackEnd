package dine.dineshotbackend.security;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dine.dineshotbackend.common.response.KakaoUserInfoDto;
import dine.dineshotbackend.common.response.KakaoUserInfoMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class KaKaoTokenUtil {

    public boolean isKakaoTokenvaild(String token){ // 토큰 유효성 검사
        System.out.println(token);
        RestTemplate restTemplate = new RestTemplate(); // restTemplate 생성
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization" , "Bearer " + token); // Header 에 토큰 담기

        HttpEntity<String> requestToKakao = new HttpEntity<>(headers);  // 카카오에서 받은요청을 responseFromKakao 라는 responseEntity 에 담음

        //responseFromKakao 에서 토큰 유효성 검사하기
        try {
            ResponseEntity<String> responseFromKakao = restTemplate.exchange(
                    "https://kapi.kakao.com/v1/user/access_token_info"
                    , HttpMethod.GET
                    , requestToKakao
                    , String.class);
            System.out.println("true");
            return true;
        } catch (Exception e){ // 유효하지 않는 토큰일경우
            System.out.println("false");
            return false;
        }
    }

    // 토큰을 통해 카카오서버에서 유저정보 가져오는 메서드
    public KakaoUserInfoDto getUserInfoFromToken(String token) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        headers.set("Content-type", "application/json");

        HttpEntity<String> requestToKakao = new HttpEntity<>(headers);  // 카카오에서 받은요청을 responseFromKakao 라는 responseEntity 에 담음

        ResponseEntity<String> responseFromKakao = restTemplate.exchange(
                "https://kapi.kakao.com/v2/user/me"
                , HttpMethod.GET
                , requestToKakao
                , String.class);
        ObjectMapper mapper = new ObjectMapper();
        KakaoUserInfoMapper dto = mapper.readValue(responseFromKakao.getBody(), KakaoUserInfoMapper.class);
        KakaoUserInfoDto kakaoUserInfoDto = KakaoUserInfoDto.builder()
                .id(dto.getId())
                .userName(dto.getProperties().get("nickname"))
                .profileImageUrl(dto.getProperties().get("profile_image"))
                .thumbImageUrl(dto.getProperties().get("thumb_image"))
                .build();

        return kakaoUserInfoDto;

    }
}
