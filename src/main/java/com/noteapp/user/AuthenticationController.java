package com.noteapp.user;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import springfox.documentation.spring.web.json.Json;


import java.io.IOException;
import java.net.URI;
import java.security.Principal;
import java.util.Map;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;

@Controller
@CrossOrigin("*")
public class AuthenticationController {

    private final UserService userService;

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

//*
// todo: user will be in data base but in boolean block him before click link on email
// */
    @PostMapping("/signup")
    public ResponseEntity<Json> save(@RequestBody SinginRequest singinRequest) throws IOException {
        User savedUser = userService.save(singinRequest);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .buildAndExpand(savedUser.getId())
                .toUri();
        Json message = new Json("{\"message\": \"We are send email to you whit link. Please confirm to make access to you account. Thanks for join\"}");
        return ResponseEntity.created(location).body(message);
    }

}
