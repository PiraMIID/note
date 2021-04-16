package com.noteapp.todos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TodoRequest {

    private final Todo todo;

    public TodoRequest(@JsonProperty("todo") Todo todo) {
        this.todo = todo;
    }

    @Override
    public String toString() {
        return "TodoRequest{" +
                "todo=" + todo +
                '}';
    }
}
