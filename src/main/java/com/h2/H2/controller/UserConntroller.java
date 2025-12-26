package com.h2.H2.controller;

import com.h2.H2.entity.User;
import com.h2.H2.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class UserConntroller {
    private  final UserService userService;

    public UserConntroller(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user)
    {
      userService.register(user);
      return  ResponseEntity.ok("registered");
    }
  @GetMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user)
    {
        Optional<User> logged=userService.login(user.getEmail(),user.getPassword());
        if(logged.isPresent()) return ResponseEntity.ok( "login successfully");
        else
        {
            return ResponseEntity.status(401).body("invalid");
        }
    }
}
