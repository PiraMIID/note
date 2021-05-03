package com.noteapp.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/*
Td activate validations in this class i need @Valid annotate in endpoints arguments
* */
public class SinginRequest {
    @NotBlank(message = "username must be not empty")
    private String username;
    @NotBlank(message = "email must ne not empty")
    @Email(message = "email form is not correctly")
    private String email;
    @Size(min = 8, max = 30, message = "size of password is not correctly")
    private String password;


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
