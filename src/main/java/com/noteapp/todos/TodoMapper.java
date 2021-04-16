package com.noteapp.todos;

public class TodoMapper {


    public static Todo toEntity(TodoDto dto) {
        Todo todo = new Todo();
        todo.setName(dto.getName());
        todo.setValue(dto.getValue());
        todo.setDone(dto.isDone());
        todo.setUser(dto.getUser());
        return todo;
    }

    public static TodoDto toDto(Todo todo) {
        TodoDto dto = new TodoDto();
        dto.setId(todo.getId());
        dto.setName(todo.getName());
        dto.setValue(todo.getValue());
        dto.setDone(todo.isDone());
        dto.setUser(todo.getUser());
        return dto;
    }
}
