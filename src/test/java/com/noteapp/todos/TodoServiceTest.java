package com.noteapp.todos;

import com.noteapp.config.User;
import com.noteapp.config.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;



class TodoServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private TodoRepository todoRepository;

    private TodoService underTest;

    @BeforeEach
    void setUp() {
//        MockitoAnnotations.openMocks(this);
        underTest = new TodoService(userRepository, todoRepository);
    }

    @Test
    void itShouldFindAll() {
        // Given
        String username = "dawid";

        User user = new User();
        user.setUsername(username);
        user.setPassword("szmajduch");
        user.setRole("ROLE_USER");

        Todo todo = new Todo("Test", "Write good test", true, user);
        Todo todo1 = new Todo("Test2", "Write good test", true, user);
        Todo todo2 = new Todo("Test3", "Write good test", true, user);

        List<Todo> todos = List.of(todo,todo1, todo2);

//        given(todoRepository.findAllByUserId(1L)).willReturn(todos);

        // When
        // Then

//        assertThat(todos).containsExactly(todo2);

//        assertThat(todos).contains(todo1);

//        assertThat(todos).hasSize(3);

    }
}
