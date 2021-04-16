package com.noteapp.jwt;

import com.noteapp.config.User;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Data
public class UserJwtToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String token;
    private LocalTime timeValid;
    @OneToOne(fetch = FetchType.LAZY)
    private User user;

}
