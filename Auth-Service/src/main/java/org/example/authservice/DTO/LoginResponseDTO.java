package org.example.authservice.DTO;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class LoginResponseDTO {


    private String token;
    public LoginResponseDTO(String token) {
       log.info(" TOKEN  generated :LoginResponseDTO");
        this.token = token;
    }


}
