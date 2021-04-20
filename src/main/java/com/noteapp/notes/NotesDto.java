package com.noteapp.notes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.noteapp.config.User;

import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties({"user"})
public class NotesDto {

    private Long id;
    private String name;
    private String description;
    private String category;
    private LocalDateTime createdAt;
    private User user;

    public NotesDto() {

    }

    public NotesDto(Long id, String name, String description, String category, LocalDateTime createdAt, User user) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.createdAt = createdAt;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "NotesDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", createdAt=" + createdAt +
                ", user=" + user +
                '}';
    }
}
