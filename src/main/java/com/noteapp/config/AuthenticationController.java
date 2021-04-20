package com.noteapp.config;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class AuthenticationController {


    @PostMapping("/login")
    @ResponseBody
    public Principal login(Principal user, @RequestAttribute("username") String username) {
        System.out.println("im username in /api/notes : " + username);
        System.out.println("3");

        return user;
    }

    @GetMapping("/login")
    @ResponseBody
    public Principal loginget(Principal user, @RequestAttribute("username") String username) {
        System.out.println("3");
        System.out.println("im username in /api/notes : " + username);
        return user;
    }


}
