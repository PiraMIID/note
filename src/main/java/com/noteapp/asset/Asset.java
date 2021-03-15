package com.noteapp.asset;

import com.noteapp.note.Note;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
//    private LocalDateTime lastModified = LocalDateTime.now();
//    @OneToMany(mappedBy = "asset")
//    private List<Note> notes = new ArrayList<>();
}
