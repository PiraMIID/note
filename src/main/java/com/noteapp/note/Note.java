package com.noteapp.note;

import com.noteapp.notes.Notes;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;
    private String txtValue;

    @ManyToOne
    @JoinColumn(
            name = "notes_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "notes_note_id"
            )
    )
    private Notes notes;

    //todo: is not tested. Is this works ?
    @Lob
    @Column(
        name = "screen",
        columnDefinition = "BOLB"
    )
    private byte[] screen;
    private String note;
}
