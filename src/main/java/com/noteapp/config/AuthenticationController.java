package com.noteapp.config;

import com.noteapp.exceptions.ApiRequestExcaption;
import com.noteapp.jwt.UsernameAndPasswordAuthenticationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.security.Principal;

@Controller
public class AuthenticationController {

    private UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/login")
    @ResponseBody
    public Principal login(Principal user) {
        return user;
    }

    @GetMapping("/login")
    @ResponseBody
    public Principal loginget(Principal user) {
        return user;
    }

    @PostMapping("/signup")
    public ResponseEntity<UsernameAndPasswordAuthenticationRequest> save(@RequestBody User user) {
        if(user.getId() != null)
            throw new ApiRequestExcaption("Saved user can't have to id");
        User savedUser = userService.save(user);
        UsernameAndPasswordAuthenticationRequest usernameAndPasswordAuthenticationRequest = new UsernameAndPasswordAuthenticationRequest();
        usernameAndPasswordAuthenticationRequest.setUsername(savedUser.getUsername());
        usernameAndPasswordAuthenticationRequest.setPassword(user.getPassword());
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/login")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).body(usernameAndPasswordAuthenticationRequest);
    }


}
