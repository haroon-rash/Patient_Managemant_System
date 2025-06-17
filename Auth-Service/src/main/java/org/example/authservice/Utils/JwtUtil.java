package org.example.authservice.Utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
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

}