package dine.dineshotbackend.user.service;

import dine.dineshotbackend.security.KaKaoTokenUtil;
import dine.dineshotbackend.user.dto.UserJoinDTO;
import dine.dineshotbackend.user.entity.User;
import dine.dineshotbackend.user.repository.UserRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final KaKaoTokenUtil kaKaoTokenUtil;


    public UserService(UserRepository userRepository, KaKaoTokenUtil kaKaoTokenUtil) {
        this.userRepository = userRepository;
        this.kaKaoTokenUtil = kaKaoTokenUtil;
    }

    //회원가입 메서드
    @Transactional
    public boolean joinUser(UserJoinDTO dto) {
        //카카오 서버로 검증
        if(!kaKaoTokenUtil.isKakaoTokenvaild(dto.getKakaoToken())){
            return false;
        }
        //
        User user = new User();

        user.setUserCode(dto.getUserCode());
        user.setUserName(dto.getUserName());
        user.setUserAddress(dto.getUserAddress());
        user.setUserRole(dto.getUserRole());
        user.setUserProfileImg(dto.getUserProfileImg());
        user.setUserIsCEO(dto.isCeo());
        user.setUserRole("ROLE_USER");
        try{
            userRepository.save(user);
            return true;

        } catch (EntityExistsException e) {
            return false;
        }
    }

    public void getUserInformation(String userName, Integer reviewCount, String badgeName) {
        if(userName==null){

        }
    }
}
