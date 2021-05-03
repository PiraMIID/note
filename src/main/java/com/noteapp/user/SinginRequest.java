package com.noteapp.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


public class SinginRequest {
    @NotBlank private String username;
    @Email private String email;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @NotBlank private String password;


    public SinginRequest(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(password);
    }

//    needed in aspect
    @Override
    public String toString() {
        return  username + ";" +
                email + ";"+
                password;
    }
}
