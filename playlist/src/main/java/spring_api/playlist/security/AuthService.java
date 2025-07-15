package spring_api.playlist.security;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public String authentication() {
        return "token";
    }

}
