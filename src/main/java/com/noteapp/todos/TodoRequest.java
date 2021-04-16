package com.noteapp.todos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TodoRequest {

    private final TodoDto todo;

    public TodoRequest(@JsonProperty("todo") TodoDto todo) {
        this.todo = todo;
    }

    @Override
    public String toString() {
        return "TodoRequest{" +
                "todo=" + todo +
                '}';
    }
}
