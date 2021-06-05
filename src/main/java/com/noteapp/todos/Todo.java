package com.noteapp.todos;

import com.noteapp.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;



@Entity
@Getter
@Setter
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String value;
    private boolean isDone;

    @ManyToOne
    @JoinColumn(name = "user_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "user_todos_fk"
            ))
    private User user;

    public Todo() {
    }

    public Todo( @NotBlank String name, @NotBlank String value, boolean isDone, User user) {
        this.name = name;
        this.value = value;
        this.isDone = isDone;
        this.user = user;
    }
}


