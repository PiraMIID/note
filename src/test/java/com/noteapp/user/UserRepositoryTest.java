package com.noteapp.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
@ExtendWith(MockitoExtension.class)
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;


    @Test
    void findByUsername() {
        //given
        User appUser = new User();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        appUser.setUsername("dawid");
        appUser.setPassword(passwordEncoder.encode("szmajduch"));
        appUser.setRole("ROLE_USER");
        userRepository.save(appUser);
        //when

        Optional<User> user = userRepository.findByUsername("dawid");

        //then

        assertThat(user.get()).isNotNull();
    }
}
