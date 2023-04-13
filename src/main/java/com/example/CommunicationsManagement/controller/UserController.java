package com.example.CommunicationsManagement.controller;

import com.example.CommunicationsManagement.entity.UserEntity;
import com.example.CommunicationsManagement.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Api("Методы для работы с существующими пользователями")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ApiOperation("Получение списка всех пользователей")
    public List<UserEntity> usersList() {
        return userService.findAll();
    }

    @GetMapping("{id}")
    @ApiOperation("Получение пользователя по id")
    public UserEntity getUser(@PathVariable Long id) {
        return userService.findById(id).orElseThrow();
    }

    @PostMapping("/add")
    @ApiOperation("Добавление нового пользователя")
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userService.addUser(user);
    }

    @PutMapping("/edit/{id}")
    @ApiOperation("Обновление данных существующего пользователя")
    public UserEntity updateUser(@PathVariable Long id, @RequestBody UserEntity user) {
        UserEntity existingUser = userService.findById(id).orElseThrow();
        BeanUtils.copyProperties(user, existingUser, "userId", "password", "createTime", "updateTime");
        return userService.save(existingUser);
    }

}