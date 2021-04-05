package com.noteapp.config;

import com.noteapp.notes.Notes;
import com.noteapp.todos.Todos;
import lombok.Data;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@Entity
@Table(name = "user_details")
public class User implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    private String role;
    private String jwt;

//    @OneToMany(
//            mappedBy = "user",
//            fetch = FetchType.LAZY
//    )
//    List<Notes> notes;
//    @OneToMany(
//            mappedBy = "user",
//            fetch = FetchType.LAZY
//    )
//    List<Todos> todos;
//    private String test;
//    @OneToOne
//    @MapsId
//    private Assets assets;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return Collections.singleton(new SimpleGrantedAuthority(role));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
