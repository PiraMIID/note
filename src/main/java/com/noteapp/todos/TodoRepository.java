package com.noteapp.todos;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
// todo: 15: clean up
public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findAllByUserId(Long id);

    List<Todo> findAllByUserUsername(String username);

    Todo save(Todo todo);
}
