package com.noteapp.user.token;

import com.noteapp.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import springfox.documentation.spring.web.json.Json;

import javax.validation.Valid;
import java.net.URI;

@RequestMapping("")
@RestController
public class SignupController {

    private TokenService tokenService;

    public SignupController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Json> save(@RequestBody @Valid SignupRequest signupRequest) {
        User savedUser = tokenService.save(signupRequest);
        Json message = new Json("{\"message\": \"We are send message on " + signupRequest.getEmail() +" with link. Please confirm to get access to you account. Thanks for join\"}");
        URI location = ServletUriComponentsBuilder
                .fromPath("login")
                .build(savedUser);
        return ResponseEntity.created(location).body(message);

    }
}
