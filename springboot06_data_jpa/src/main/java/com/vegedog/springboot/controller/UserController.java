package com.vegedog.springboot.controller;

import com.vegedog.springboot.entity.User;
import com.vegedog.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

//    @GetMapping("/user/{id}")
//    public Object getUser(@PathVariable("id") Integer id){
//        List<User> user = userRepository.findAll();
//        return user;
//    }

    @GetMapping("/user")
    public User insertUser(User user){
        User save = userRepository.save(user);
        return save;
    }

    @GetMapping("/user/{id}")
    public Object getUserById(@PathVariable("id") Integer id){
        //List<User> user = userRepository.findAll();
        Optional<User> user = userRepository.findById(id);
        return user;
    }

}
