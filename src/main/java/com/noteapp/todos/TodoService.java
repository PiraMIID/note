package com.noteapp.todos;

import com.noteapp.user.User;
import com.noteapp.user.UserRepository;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;




    public TodoService(UserRepository userRepository, TodoRepository todoRepository) {
        this.userRepository = userRepository;
        this.todoRepository = todoRepository;
    }

    List<TodoDto> findAll(String username) {
        return todoRepository.findAllByUserUsername(username)
                .stream()
                .map(TodoMapper::toDto)
                .collect(Collectors.toList());
    }

    TodoDto save(String username, TodoDto todoDto) {
        Optional<User> user = userRepository.findByUsername(username);
        Todo todo = TodoMapper.toEntity(todoDto);
        todo.setUser(user.get());
        Todo saveTodo = todoRepository.save(todo);
        return TodoMapper.toDto(saveTodo);
    }

    List<TodoDto> findAllByUsername(String username) {
        List<Todo> todos = todoRepository.findAllByUserUsername(getUsernameFromSecurity());
        return todos.stream()
                .map(TodoMapper::toDto)
                .collect(Collectors.toList());

    }

    TodoDto isDoneUpdate(Long id, boolean isDone) {
        Todo one = todoRepository.getOne(id);
        one.setDone(isDone);
        Todo save = todoRepository.save(one);
        return TodoMapper.toDto(save);
    }

    void delete(Long id) {
        todoRepository.deleteById(id);
    }

    String getUsernameFromSecurity() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
