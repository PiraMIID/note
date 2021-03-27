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
        userRepository.save(appUser);

        Assets assetsUser = new Assets();

        assetsUser.setName("nota 1");
        assetsUser.setDescription("opis");
        assetsUser.setCategory("category");
//        assetsUser.setUser(appUser);
        assetsRepository.save(assetsUser);

        Assets assetsUser0 = new Assets();

        assetsUser0.setName("nota 2");
        assetsUser0.setDescription("opis");
        assetsUser0.setCategory("category");
//        assetsUser0.setUser(appUser);
        assetsRepository.save(assetsUser0);

        Assets assetsUser1 = new Assets();

        assetsUser1.setName("nota 3");
        assetsUser1.setDescription("opis");
        assetsUser1.setCategory("category");
//        assetsUser1.setUser(appUser);
        assetsRepository.save(assetsUser1);






//        appUser.setAssets(assetsUser);






        System.out.println();
    }

}
