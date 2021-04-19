package com.noteapp.controller;


import io.swagger.annotations.ResponseHeader;
import org.apache.catalina.connector.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//todo: change the main ptah to e.g. v1/user/notes
@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(@RequestParam(value = "username",required = false) String username, Model model, @RequestAttribute(value = "username", required = false) String usernamee) {
        System.out.println(username + "username");
        model.addAttribute("siema"," no elo xd");
        System.out.println(model);
        System.out.println("im username in /api/notes : " + usernamee);
        return "index.html";
    }
}

