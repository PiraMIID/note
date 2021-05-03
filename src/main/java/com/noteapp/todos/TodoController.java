package com.noteapp.todos;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller("/api/todo")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }


    @GetMapping("")
    public List<TodoDto> getListTodo(@RequestAttribute("username") String username) {
        return todoService.findAll(username);
    }

    @PostMapping("/create")
    public ResponseEntity<TodoDto> save(@RequestAttribute("username") String username, @RequestBody TodoDto todo) {
        TodoDto savedTodo = todoService.save(username, todo);
        return ResponseEntity.ok(savedTodo);
    }

    @PostMapping("/{id}/")
    public ResponseEntity<TodoDto> isDoneUpdate(@PathParam("status") boolean isDone, @PathVariable Long id) {
        TodoDto updatedTodo = todoService.isDoneUpdate(id, isDone);
        return ResponseEntity.ok(updatedTodo);
    }

    @DeleteMapping("/{id}/")
    public Long delete(@PathVariable Long id) {
        todoService.delete(id);
        return id;
    }

}
