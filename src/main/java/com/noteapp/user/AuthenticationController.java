package com.noteapp.user;

import java.security.Principal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("")
@RestController
//@CrossOrigin("*")
public class AuthenticationController {

  private final UserService userService;

  public AuthenticationController(UserService userService) {
    this.userService = userService;
  }


  @PostMapping("/login")
  @ResponseBody
  public Principal login(Principal user) {
    return user;
  }

  @GetMapping("/login")
  @ResponseBody
  public Principal loginget(Principal user) {
    return user;
  }

}
