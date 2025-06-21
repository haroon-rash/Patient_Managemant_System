package org.example.authservice.Utils;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import io.jsonwebtoken.security.SignatureException;
import java.util.Base64;
import java.util.Date;

@Slf4j
@Component
public class JwtUtil {

    private final Key securityKey;

    public JwtUtil(@Value("${jwt.secret}") String secret) {

        byte[] decodedKey = Base64.getDecoder().decode(secret.getBytes(StandardCharsets.UTF_8));
        this.securityKey = Keys.hmacShaKeyFor(decodedKey);
log.info("JWT Secret: {}", secret);

    }



    public String generateToken(String email,String role) {


        log.info("Generate JWT Token");

      return Jwts.builder()
              .subject(email)
              .claim("role", role)
              .issuedAt(new Date())
              .expiration(new Date(System.currentTimeMillis()+1000*60*60*10)) //validation for 10 hours
              .signWith(securityKey)
              .compact();

    }

    public void validateToken(String token)  {
        try {
            Jwts.parser()
                    .verifyWith((SecretKey) securityKey)
                    .build()
                    .parseSignedClaims(token);
        } catch (SignatureException e) {
            throw new SignatureException("Invalid JWT signature");
        } catch (JwtException e) {
            throw new JwtException("Invalid JWT", e);
        }
    }


}