package com.takeyourpic.backend.service;

import com.takeyourpic.backend.model.User;
import com.takeyourpic.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUser(Long id){
        Optional<User> user = userRepository.findById(id);

        return user;
    }

    public String updateUser(Long id, User user){
        User foundUser = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("User does not exist"));

        if (foundUser != null){
            foundUser.setUsername(user.getUsername());
            userRepository.flush();
        }

        return "Successfully updated";
    }

    public String deleteUser(Long id){
        User foundUser = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("User does not exist"));

        if (foundUser != null){
            userRepository.deleteById(id);
        }
            return "Successfully deleted";
    }
}
