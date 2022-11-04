package com.takeyourpic.backend.controller;

import com.takeyourpic.backend.model.User;
import com.takeyourpic.backend.service.CustomUserDetailsService;
import com.takeyourpic.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUsers(){

        return userService.getAllUsers();
    }

    @GetMapping(path = "/{id}")
    public Optional<User> getUser(@PathVariable("id") Long id){
        return userService.getUser(id);
    }

    @PutMapping(path = "/{id}")
    public String updateUser(@RequestBody User user, @PathVariable("id") Long id){

        return userService.updateUser(id, user);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        return userService.deleteUser(id);
    }
}
