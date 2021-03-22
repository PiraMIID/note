package com.noteapp.asset;

import com.noteapp.config.User;
import com.noteapp.note.Note;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String category;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
