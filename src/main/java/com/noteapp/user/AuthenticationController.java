package com.noteapp.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import springfox.documentation.spring.web.json.Json;

import javax.validation.Valid;
import java.net.URI;
import java.security.Principal;

@RequestMapping("")
@RestController
//@CrossOrigin("*")
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

    //   /*
//   is not working how i want
//    this concept if i will understand i will better understand of all java things
//   */
    @PostMapping("/signup")
    public ResponseEntity<Json> save(@RequestBody @Valid SinginRequest singinRequest) {
        User savedUser = userService.save(singinRequest);
        Json message = new Json("{\"message\": \"We are send message on " + singinRequest.getEmail() +" with link. Please confirm to get access to you account. Thanks for join\"}");
        URI location = ServletUriComponentsBuilder
                .fromPath("login")
                .build(savedUser);
        return ResponseEntity.created(location).body(message);

    }


}
