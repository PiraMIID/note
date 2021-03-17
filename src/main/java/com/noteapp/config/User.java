package com.noteapp.config;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.management.relation.Role;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;

@Data
@Entity
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    private Role role;
}
