package com.noteapp.note;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;
    @Lob
    @Column(name = "screen", columnDefinition = "BOLB")
    private byte[] screen;
    private String note;
}
