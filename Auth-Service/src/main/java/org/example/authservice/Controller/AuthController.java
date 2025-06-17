package org.example.authservice.Controller;

import lombok.extern.slf4j.Slf4j;
import org.example.authservice.DTO.LoginRequestDTO;
import org.example.authservice.DTO.LoginResponseDTO;
import org.example.authservice.Service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

@PostMapping("/login")
public ResponseEntity<?>login(@RequestBody LoginRequestDTO loginRequestDTO) {

    Optional<String> token=authService.authenticate(loginRequestDTO);
    if(token.isEmpty()){
        log.info("Token is empty controller messages ");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    log.info("Token is valid");
    String tokens=token.get();

    return ResponseEntity.ok(new LoginResponseDTO(tokens));



}


}
