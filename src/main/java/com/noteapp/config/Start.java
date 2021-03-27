package com.noteapp.config;

import com.noteapp.assets.Assets;
import com.noteapp.assets.AssetsRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;;import java.util.Arrays;

@Configuration
public class Start {

    public Start(AssetsRepository assetsRepository,UserRepository userRepository, PasswordEncoder passwordEncoder) {
        User appUser = new User();
        appUser.setUsername("dawid");
        appUser.setPassword(passwordEncoder.encode("szmajduch"));
        appUser.setRole("ROLE_USER");
//        appUser.setTest("asd");
//        userRepository.save(appUser);
        Assets assetsUser = new Assets();
//        assetsUser.setUser(appUser);
        assetsUser.setName("elo");
        assetsUser.setDescription("opis");
        assetsUser.setCategory("category");


//        assetsRepository.save(assetsUser);
//        appUser.setAssets(assetsUser);
        userRepository.save(appUser);
        assetsUser.setUser(appUser);

        assetsRepository.save(assetsUser);


        System.out.println();
    }

}
