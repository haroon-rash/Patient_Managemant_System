package org.example.authservice.Service;

import io.jsonwebtoken.JwtException;
import lombok.extern.slf4j.Slf4j;
import org.example.authservice.DTO.LoginRequestDTO;

import org.example.authservice.Utils.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Slf4j
@Service
public class AuthService {

    private final UserService userservice;
    private final JwtUtil jwtUtil;
private final PasswordEncoder passwordEncoder;
    public AuthService(UserService userService, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userservice = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }


    public Optional<String> authenticate(LoginRequestDTO loginRequestDTO) {

log.info("Authenticating {}", loginRequestDTO);
        return userservice.findByEmail(loginRequestDTO.getEmail())
                .filter(u -> passwordEncoder.matches(loginRequestDTO.getPassword(),u.getPassword()))
                .map(u->jwtUtil.generateToken(u.getEmail(),u.getRole()));



    }


    public boolean validateToken(String token) {
        try{
            jwtUtil.validateToken(token);
            return true;
        }catch (JwtException e){
            return false;
        }

    }



}
