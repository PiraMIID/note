package com.noteapp.todos;

import com.noteapp.config.User;
import com.noteapp.config.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class TodoRepositoryTest {
    @Autowired
    private TodoRepository underTest;
    @Autowired
    private UserRepository userRepository;


    @Test
    void itShouldFindAllByUserName() {
        // Given
        String username = "dawid";
        User user = new User();
        user.setUsername(username);
        user.setPassword("szmajduch");
        user.setRole("ROLE_USER");
        String value = "Write good test";
        String test = "Test";
        Todo todo = new Todo(test, value, true, user);

        userRepository.save(user);
        underTest.save(todo);

        // When
        List<Todo> todos = underTest.findAllByUserUsername(user.getUsername());

        // Then
        assertThat(todos).extracting(Todo::getUser).containsExactly(user);

    }
}
