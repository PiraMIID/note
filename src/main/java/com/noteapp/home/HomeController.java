package com.noteapp.home;


import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(@RequestAttribute(value = "username", required = false) String username, HttpServletResponse response) {
        response.setHeader("username", username);

        System.out.println("user name from context holder" + SecurityContextHolder.getContext().getAuthentication().getName());
        return "index.html";
    }
}

