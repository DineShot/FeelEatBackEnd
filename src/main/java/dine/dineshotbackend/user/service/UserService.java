package dine.dineshotbackend.user.service;

import dine.dineshotbackend.security.KaKaoTokenUtil;
import dine.dineshotbackend.user.dto.UserFindDTO;
import dine.dineshotbackend.user.dto.UserJoinDTO;
import dine.dineshotbackend.user.entity.User;
import dine.dineshotbackend.user.repository.UserRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<UserFindDTO> getUserInformation(String userName, Integer reviewCount, String badgeName) {
        List<UserFindDTO> userFindDTOList = new ArrayList<>();
        List<User> userEntity = new ArrayList<>();
        if(badgeName==null && reviewCount==null){
            //아이디로 검색
            userEntity = userRepository.findAllByUserNameContaining(userName);
        }else if(badgeName==null){
            //리뷰 수로 검색
            userEntity = userRepository.selectUserByReviewCount(reviewCount);
        } else if(reviewCount==null){
            //뱃지를 갖고 있는 사용자를 검색
            userEntity = userRepository.selectUserByBadge(badgeName);
        }
        for(User user : userEntity){
            UserFindDTO userFindDTO = new UserFindDTO();
            userFindDTO.setUserName(user.getUserName());
            userFindDTO.setUserIsCeo(user.isUserIsCEO());
            userFindDTO.setUserProfileImage(user.getUserProfileImg());
            userFindDTO.setUserCode(user.getUserCode());
            userFindDTOList.add(userFindDTO);
        }
        return userFindDTOList;
    }
}
