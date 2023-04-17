package com.example.CommunicationsManagement.controller;

import com.example.CommunicationsManagement.entity.RoleEntity;
import com.example.CommunicationsManagement.entity.UserEntity;
import com.example.CommunicationsManagement.entity.UserRoleEntity;
import com.example.CommunicationsManagement.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

@RestController
@RequestMapping("/roles")
@Api("Методы обработки ролей пользователей")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    @ApiOperation("Выгрузка списка всех ролей")
    public List<RoleEntity> rolesList() {
        return roleService.findAll();
    }

    @GetMapping("{id}")
    @ApiOperation("Выгрузка роли по id")
    public RoleEntity getRole(@PathVariable Long id) {
        return roleService.findById(id).orElseThrow();
    }

    @GetMapping("users/{id}")
    @ApiOperation("Выгрузка всех пользователей роли по id")
    public List<UserEntity> getUsersByRoleId(@PathVariable Long id) {
        return roleService.findUsersByRoleId(id);
    }

    @PostMapping("/add/role/{roleId}{userId}")
    @ApiOperation("Добавление роли для пользователя")
    public ResponseEntity<String> addRoleToUser(@PathVariable Long roleId, @PathVariable Long userId) {
        if (Objects.nonNull(roleService.addRoleToUser(roleId, userId))) {
            new ResponseEntity<>("Role " + roleId + " successfully added to user " + userId, HttpStatus.OK);
        }
        return new ResponseEntity<>("Role " + roleId + " not added to user " + userId + ". Check input data.", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/add")
    @ApiOperation("Добавление роли")
    public RoleEntity createRole(@RequestBody RoleEntity role) {
        return roleService.save(role);
    }

    @PutMapping("/edit/{id}")
    @ApiOperation("Обновление данных роли по id")
    public RoleEntity updateRole(@PathVariable Long id, @RequestBody RoleEntity role) {
        RoleEntity existingRole = roleService.findById(id).orElseThrow();
        BeanUtils.copyProperties(role, existingRole, "roleId", "createTime", "updateTime");
        return roleService.save(existingRole);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Удаление роли по id")
    public ResponseEntity<Map<String, String>> deleteRole(@PathVariable Long id) {
        if (roleService.deleteById(id) > 0) {
            return new ResponseEntity<>(Map.of("description", "Роль успешно удалена", "id", id.toString()), HttpStatus.OK);
        } else {
            throw new NoSuchElementException("No such element by id " + id);
        }
    }

    @DeleteMapping("/delete/role/{roleId}{userId}")
    @ApiOperation("Удаление роли (по id) у пользователя по id")
    public ResponseEntity<Map<String, String>> deleteRoleFromUser(@PathVariable Long roleId, @PathVariable Long userId) {
        if (roleService.deleteRoleFromUser(roleId, userId) > 0) {
            return new ResponseEntity<>(Map.of("description", "Роль " + roleId + " у пользователя " + userId + " успешно удалена"), HttpStatus.OK);
        } else {
            throw new NoSuchElementException("No such element by role id" + roleId + " and user id " + userId);
        }
    }

}