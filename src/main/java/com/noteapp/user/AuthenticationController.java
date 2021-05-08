package com.noteapp.user;

import com.noteapp.user.token.SignupRequest;
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

}
