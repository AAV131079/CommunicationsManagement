package com.example.CommunicationsManagement.service;

import com.example.CommunicationsManagement.entity.RoleEntity;
import com.example.CommunicationsManagement.entity.UserEntity;
import com.example.CommunicationsManagement.entity.UserRoleEntity;
import com.example.CommunicationsManagement.repository.UserRepository;
import com.example.CommunicationsManagement.repository.UserRoleRepository;
import com.example.CommunicationsManagement.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    private final UserRoleRepository userRoleRepository;

    private final UserRepository userRepository;

    public RoleService(RoleRepository roleRepository, UserRoleRepository userRoleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
    }

    public List<RoleEntity> findAll() {
        return roleRepository.findAll();
    }

    public Optional<RoleEntity> findById(Long id) {
        return roleRepository.findById(id);
    }

    public List<UserEntity> findUsersByRoleId(Long id) {
        return userRoleRepository.findUsersFromRoleById(id);
    }

    public RoleEntity save(RoleEntity role) {
        return roleRepository.save(role);
    }

    public int deleteById(Long id) {
        return roleRepository.deleteByRoleId(id);
    }

    public UserRoleEntity addRoleToUser(Long roleId, Long userId) {
        return userRoleRepository
                .save(
                        new UserRoleEntity(userRepository.findByUserId(userId), roleRepository.findByRoleId(roleId))
                );
     }

    public int deleteRoleFromUser(Long roleId, Long userId) {
        return userRoleRepository.deleteRoleFromUser(roleId, userId);
    }




}