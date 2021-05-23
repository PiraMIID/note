package com.noteapp.user;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ContextConfiguration(classes = {UserRepository.class})
@EnableAutoConfiguration
@DataJpaTest
@ExtendWith(MockitoExtension.class)
class UserRepositoryTest {

    @Autowired
    UserRepository underTest;


    @Test
    void findByUsername() {
        //given
        User appUser = new User();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        appUser.setUsername("dawid");
        appUser.setPassword(passwordEncoder.encode("szmajduch"));
        appUser.setRole("ROLE_USER");
        underTest.save(appUser);
        //when

        Optional<User> user = underTest.findByUsername("dawid");

        //then

        assertThat(user.get()).isNotNull();
    }

    @Test
    public void testRemoveIfAccountIsNotConfirmAndTokenNotExist() {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setRole("Role");
        user.setAccountNonLocked(true);
        user.setUsername("janedoe");
        user.setId(123L);

        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setPassword("iloveyou");
        user1.setRole("Role");
        user1.setAccountNonLocked(true);
        user1.setUsername("janedoe");
        user1.setId(123L);
        this.underTest.<User>save(user);
        this.underTest.<User>save(user1);
        this.underTest.removeIfAccountIsNotConfirmAndTokenNotExist();
        List<User> findAllResult = this.underTest.findAll();
        assertTrue(findAllResult instanceof ArrayList);
        assertEquals(2, ((ArrayList) findAllResult).size());
        Object getResult = ((ArrayList) findAllResult).get(0);
        assertTrue(getResult instanceof User);
        Object getResult1 = ((ArrayList) findAllResult).get(1);
        assertTrue(getResult1 instanceof User);
        assertTrue(((User) getResult1).isEnabled());
        assertTrue(((User) getResult1).isCredentialsNonExpired());
        assertTrue(((User) getResult1).isAccountNonLocked());
        assertTrue(((User) getResult1).isAccountNonExpired());
        assertEquals("janedoe", ((User) getResult1).getUsername());
        assertEquals("Role", ((User) getResult1).getRole());
        assertEquals("iloveyou", ((User) getResult1).getPassword());
        assertEquals("jane.doe@example.org", ((User) getResult1).getEmail());
        assertTrue(((User) getResult).isEnabled());
        assertTrue(((User) getResult).isCredentialsNonExpired());
        assertTrue(((User) getResult).isAccountNonLocked());
        assertTrue(((User) getResult).isAccountNonExpired());
        assertEquals("janedoe", ((User) getResult).getUsername());
        assertEquals("Role", ((User) getResult).getRole());
        assertEquals("iloveyou", ((User) getResult).getPassword());
        assertEquals("jane.doe@example.org", ((User) getResult).getEmail());
    }
}
