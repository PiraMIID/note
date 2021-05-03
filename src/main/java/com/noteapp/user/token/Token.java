package com.noteapp.user.token;

import com.noteapp.user.User;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String token;
    @Column(nullable = false)
    private LocalDate tokenExpiresAt;
    @ManyToOne
    @JoinColumn(name = "user_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "user_token_fk"
            ))
    private User user;
}
