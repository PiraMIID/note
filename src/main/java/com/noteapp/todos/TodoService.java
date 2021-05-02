package com.noteapp.todos;

import com.noteapp.config.User;
import com.noteapp.config.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoService {

    private TodoRepository todoRepository;
    private UserRepository userRepository;


    public TodoService(UserRepository userRepository, TodoRepository todoRepository) {
        this.userRepository = userRepository;
        this.todoRepository = todoRepository;
    }

    List<TodoDto> findAll(String username) {
        System.out.println(username + " in Todo Service");
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
