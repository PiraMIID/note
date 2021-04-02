package com.noteapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//todo: change the main ptah to e.g. v1/user/notes
@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "index.html";
    }
}
