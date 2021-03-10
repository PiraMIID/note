package com.noteapp.security;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

public class AuthentionController {
    @PostMapping("/user-login")
    @ResponseBody
    public Principal login(Principal user) {
        return user;
    }
}
