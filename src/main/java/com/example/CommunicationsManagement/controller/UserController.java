package com.example.CommunicationsManagement.controller;

import com.example.CommunicationsManagement.entity.UserEntity;
import com.example.CommunicationsManagement.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserEntity> usersList() {
        return userService.findAll();
    }

    @GetMapping("{id}")
    public UserEntity getUser(@PathVariable Long id) {
        return userService.findById(id).orElseThrow();
    }

    @PostMapping("/add")
    public UserEntity createUser(@RequestBody UserEntity user) {

        return userService.addUser(user);
    }

    @PutMapping("/edit/{id}")
    public UserEntity updateUser(@PathVariable Long id,
                                 @RequestBody UserEntity user) {
        UserEntity existingUser = userService.findById(id).orElseThrow();
        BeanUtils.copyProperties(user, existingUser, "userId", "password", "createTime", "updateTime");

        return userService.save(existingUser);
    }

}
