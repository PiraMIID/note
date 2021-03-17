package com.noteapp.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class AuthenticationController {

    private UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    @ResponseBody
    public String homePage() {
        return "";
    }

    @PostMapping("/login")
    @ResponseBody
    public Principal login(Principal user) {
        return user;
    }

    @GetMapping("/login")
    @ResponseBody
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    @ResponseBody
    public String signup() {
        return "signup";
    }

    @PostMapping("/signup")
    public UserDto singup(@RequestBody User user) {
        return new UserDto();
    }
}
