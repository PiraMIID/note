package com.noteapp.user.token;

import com.noteapp.email.MailService;
import com.noteapp.user.User;
import com.noteapp.user.email.MailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import springfox.documentation.spring.web.json.Json;

import javax.mail.MessagingException;
import javax.swing.text.BadLocationException;
import javax.validation.Valid;

import javax.websocket.server.PathParam;
import java.io.IOException;

import java.io.IOException;
import java.net.MalformedURLException;

import java.net.URI;

@RequestMapping("")
@RestController
public class SignupController {

    private final TokenService tokenService;


    public SignupController(TokenService tokenService, MailService mailService) {
        this.tokenService = tokenService;
        this.mailService = mailService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Json> save(@RequestBody @Valid SignupRequest signupRequest) throws MessagingException, IOException, BadLocationException {
        User savedUser = tokenService.save(signupRequest);
        Json message = new Json("{\"message\": \"We are send message on " + signupRequest.getEmail() +" with link. Please confirm to get access to you account. Thanks for join\"}");
        mailService.sendMail("dszmajduch@gmail.com", signupRequest.getUsername(),"token");
        URI location = ServletUriComponentsBuilder
                .fromPath("login")
                .build(savedUser);
        return ResponseEntity.created(location).body(message);

    }


    @GetMapping("/confirm")
    public ResponseEntity<User> confirmToken(@PathParam("token") String token) {
        System.out.println(token);
        User savedUser = tokenService.confirmAccount(token);
        URI location = ServletUriComponentsBuilder
                .fromPath("login")
                .build(savedUser);
        return ResponseEntity.created(location).body(savedUser);

}
