package com.noteapp.config;

import com.noteapp.notes.Notes;
import com.noteapp.notes.NotesRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;;import java.time.LocalDateTime;

@Configuration
public class Start {

    public Start(NotesRepository notesRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {

        User appUser = new User();

        appUser.setUsername("dawid");
        appUser.setPassword(passwordEncoder.encode("szmajduch"));
        appUser.setRole("ROLE_USER");
        userRepository.save(appUser);

        Notes notesUser = new Notes();

        notesUser.setName("nota 1");
        notesUser.setDescription("opis");
        notesUser.setCreatedAt(LocalDateTime.now());
        notesUser.setUser(appUser);
        notesRepository.save(notesUser);

        Notes notesUser0 = new Notes();

        notesUser0.setName("nota 2");
        notesUser0.setDescription("opis");
        notesUser0.setCreatedAt(LocalDateTime.now());
        notesUser0.setUser(appUser);
        notesRepository.save(notesUser0);

        Notes notesUser1 = new Notes();

        notesUser1.setName("nota 3");
        notesUser1.setDescription("opis");
        notesUser1.setCreatedAt(LocalDateTime.now());
        notesUser1.setUser(appUser);
        notesRepository.save(notesUser1);






//        appUser.setAssets(assetsUser);






        System.out.println();
    }

}
