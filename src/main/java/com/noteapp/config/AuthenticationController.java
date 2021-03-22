package com.noteapp.config;

import com.noteapp.asset.Asset;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class AuthenticationController {


    @PostMapping("/login")
    @ResponseBody
    public Principal login(Principal user) {

        System.out.println("3");
        return user;
    }
}