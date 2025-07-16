package spring_api.playlist.security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {


    private JwtService jwtService;

    public AuthService(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    public String authentication(Authentication authentication) {
        return jwtService.tokenGenerator(authentication);
    }

}
