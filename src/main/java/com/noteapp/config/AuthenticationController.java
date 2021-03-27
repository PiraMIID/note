package com.noteapp.config;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
@Scope("session")
public class AuthenticationController {


    @PostMapping("/login")
    @ResponseBody
    public Principal login(Principal user) {
        System.out.println("3");

        return user;
    }

}
