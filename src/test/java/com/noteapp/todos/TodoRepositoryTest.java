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
        Random random = new Random();
//        Long id = 3L;
//        System.out.println(id);
        String username = "dawid";

        User user = new User();
//        user.setId(id);
        user.setUsername(username);
        user.setPassword("szmajduch");
        user.setRole("ROLE_USER");

//        id = random.nextLong();
        String value = "Write good test";
        Todo todo = new Todo("Test", value, true, user);

        // When
        userRepository.save(user);
        underTest.save(todo);
        // Then

        List<Todo> todos = underTest.findAllByUserId(user.getId());

        System.out.println(todo.getUser());

        assertThat(todo).extracting(Todo::getUser).isEqualTo(user);

    }
}
