package spring_api.playlist.security;


import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class JwtService {

    private JwtEncoder encoder;

    public JwtService(JwtEncoder encoder) {
        this.encoder = encoder;
    }

    public String tokenGenerator(Authentication authentication) {
        Instant now = Instant.now();

        Long expiry = 3600L;

        String scopes = "";

        return scopes;
    }
}
