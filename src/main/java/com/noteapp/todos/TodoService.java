package com.noteapp.todos;

import com.noteapp.config.User;
import com.noteapp.config.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    private TodoRepository todoRepository;


    public TodoService(UserRepository userRepository, TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    List<TodoDto> findAll(Long userId) {
        return todoRepository.findAllByUserId(userId)
                .stream()
                .map(TodoMapper::toDto)
                .collect(Collectors.toList());
    }

    TodoDto save(TodoDto todo) {
    }
}
