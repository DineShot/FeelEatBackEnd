package dine.dineshotbackend.security.config;

import dine.dineshotbackend.security.KaKaoTokenUtil;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UserDetailsService userDetailsService;
    private final KaKaoTokenUtil kaKaoTokenUtil;

    public CustomAuthenticationProvider(UserDetailsService userDetailsService, KaKaoTokenUtil kaKaoTokenUtil) {
        this.userDetailsService = userDetailsService;
        this.kaKaoTokenUtil = kaKaoTokenUtil;
    }


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String kakaoToken = (String) authentication.getCredentials();
        if(!kaKaoTokenUtil.isKakaoTokenvaild(kakaoToken)){
            throw new UsernameNotFoundException("kakao token not vaild");
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (userDetails == null) {
            throw new UsernameNotFoundException("User not found");
        }

        // 비밀번호 검증을 건너뛴다
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}