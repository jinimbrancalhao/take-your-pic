package com.takeyourpic.backend.controller;

import com.takeyourpic.backend.model.User;
import com.takeyourpic.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping
    public String helloWorld(CsrfToken csrfToken){
        return "Hello World" + " token: " + csrfToken.getToken();
    }

    @PostMapping
    public String registerUser(@RequestBody final User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return "Successfully registered user";
    }
}
