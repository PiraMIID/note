package com.noteapp.todos;

import com.noteapp.user.User;
import com.noteapp.user.UserRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Aspect
@Service
@EnableAspectJAutoProxy
public class TodoService {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;
    private String username;




    public TodoService(UserRepository userRepository, TodoRepository todoRepository) {
        this.userRepository = userRepository;
        this.todoRepository = todoRepository;
    }

    List<TodoDto> findAll(String username) {
        System.out.println(username + " in Todo Service");
        System.out.println(this.username);
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

    public List<TodoDto> findAllByUsername(String username) {
        List<Todo> todos = todoRepository.findAllByUserUsername(username);
        return todos.stream()
                .map(TodoMapper::toDto)
                .collect(Collectors.toList());

    }

    public TodoDto isDoneUpdate(Long id, boolean isDone) {
        Todo one = todoRepository.getOne(id);
        one.setDone(isDone);
        Todo save = todoRepository.save(one);
        return TodoMapper.toDto(save);
    }

    public void delete(Long id) {
        todoRepository.deleteById(id);
    }
}
