package com.noteapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;;

@Configuration
public class Start {

    public Start(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        User appUser = new User();
        appUser.setUsername("dawid");
        appUser.setPassword(passwordEncoder.encode("szmajduch"));
        appUser.setRole("ROLE_USER");
        userRepository.save(appUser);

    }

}
