package com.noteapp.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class AuthenticationController {
    @PostMapping("/login")
    @ResponseBody
    public Principal login(Principal user) {
        return user;
    }
}
