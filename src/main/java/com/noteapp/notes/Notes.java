package com.noteapp.notes;

import com.noteapp.note.Note;
import com.noteapp.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    private String description;
    @Column(
            name = "created_at",
            nullable = false
    )
    private LocalDateTime createdAt;

    @OneToMany(
            mappedBy = "notes",
            cascade = {
                    CascadeType.ALL
            }
    )
    private List<Note> notes;
    @ManyToOne
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "user_notes_fk"
            )
    )
    private User user;

    public Notes(@NotBlank String name, String description, LocalDateTime createdAt,
        List<Note> notes, User user) {
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.notes = notes;
        this.user = user;
    }
}
