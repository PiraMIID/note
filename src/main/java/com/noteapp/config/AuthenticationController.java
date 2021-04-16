package com.noteapp.config;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class AuthenticationController {


    @PostMapping("/login")
    @ResponseBody
    public Principal login(Principal user) {
        System.out.println("3");

        return user;
    }

    @GetMapping("/login")
    @ResponseBody
    public Principal loginget(Principal user) {
        System.out.println("3");

        return user;
    }

    @GetMapping("/api/username")
    public String getUserName(@RequestBody(required = true) String userName) {
        System.out.println("user endpoint" + userName);
        return userName;
    }

}
