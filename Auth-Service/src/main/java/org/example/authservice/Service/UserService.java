package org.example.authservice.Service;

import lombok.extern.slf4j.Slf4j;
import org.example.authservice.Model.User;
import org.example.authservice.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByEmail(String email) {


        log.info("Find user by email: {}", email);

        return userRepository.findByEmail(email);

    }
}
