package com.noteapp.notes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.noteapp.config.User;
import com.noteapp.note.Note;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
//@EqualsAndHashCode
@Entity
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private List <Note> notes;
    @ManyToOne
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                name = "user_notes_fk"
            )
    )
    private User user;
}
