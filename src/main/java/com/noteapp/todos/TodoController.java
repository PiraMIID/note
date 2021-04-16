package com.noteapp.todos;

import com.noteapp.config.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller("/api/todo/thjk/hgj")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }


//    @GetMapping("")
//    public List<TodoDto> getListTodo(@RequestBody Long userId) {
//        return todoService.findAll(userId).subList(0,4);
//    }

//    @PostMapping("/create")
//    public ResponseEntity<TodoDto> save(@RequestBody TodoDto todo) {
//        TodoDto savedTodo = todoService.save(todo);
//        return ResponseEntity.ok(savedTodo);
//    }
//    @GetMapping("/{id}/eidt")
//    @PostMapping("/{id}/edit")
//    @PostMapping("/{id}/remove")
//    @PostMapping("/isdone")

}
