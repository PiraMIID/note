package com.noteapp.controller;


import com.noteapp.config.User;
import com.noteapp.config.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

//todo: change the main ptah to e.g. v1/user/notes
@Controller
public class HomeController {

    private UserRepository userRepository;

    public HomeController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/")
    public String home() {
        return "index.html";
    }

    @GetMapping("/api/token")
    public ResponseEntity<User> getUserToken(@RequestHeader("jwt") String token) {
        System.out.println("I'm in /api/token :" + token);
        return new ResponseEntity<>(userRepository.getOne(1L), HttpStatus.ACCEPTED);
    }
}
