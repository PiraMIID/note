package com.noteapp.assets;

import com.noteapp.config.User;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Assets {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String category;
    //i must to better understand this
    @OneToOne(mappedBy = "assets")
    private User user;
}
