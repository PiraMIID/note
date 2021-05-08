package com.noteapp.user.token;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import net.bytebuddy.asm.Advice;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;

import javax.validation.Payload;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.executable.ValidateOnExecution;
import java.util.Locale;


public class SignupRequest {
    @NotBlank(message = "username can not be empty")
    private String username;
    @NotBlank(message = "email not be empty")
    @Email(message = "email form is not correctly")
    private String email;
    @Size(min = 8, max=100,  message = "password must have more then 8 chars not correctly")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull
    private String password;

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
        this.email = email.toLowerCase();
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
