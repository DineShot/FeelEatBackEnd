package dine.dineshotbackend.security.service;

import dine.dineshotbackend.security.dto.CustomUserDetails;
import dine.dineshotbackend.user.entity.User;
import dine.dineshotbackend.user.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //매니저가 UserDetailsService 를 구현한 클래스를 찾아 이 메서드를 실행시킨다.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Long userCode = Long.valueOf(username);
            System.out.println("userCode = " + userCode);
            User userData = userRepository.findById(userCode).orElseThrow();   //유저의 정보를 DB 에서 조회해오고,
            return new CustomUserDetails(userData);
        } catch (Exception e){
            return null;
        }

    }
}
