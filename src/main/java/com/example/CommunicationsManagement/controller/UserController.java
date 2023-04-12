package com.example.CommunicationsManagement.controller;

import com.example.CommunicationsManagement.entity.UserEntity;
import com.example.CommunicationsManagement.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;


    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<UserEntity> usersList() {

        return userRepository.findAll();
    }

    @GetMapping("{id}")
    public UserEntity getUser(@PathVariable UserEntity user) {

        return user;
    }

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user) {

        return userRepository.save(user);
    }

    @PutMapping("{id}")
    public UserEntity updateUser(@PathVariable UserEntity userFromDB,
                                 @RequestBody UserEntity user) {

        BeanUtils.copyProperties(user, userFromDB, "userId");

        return userRepository.save(userFromDB);
    }

}
