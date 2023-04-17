package com.example.CommunicationsManagement.repository;

import com.example.CommunicationsManagement.entity.RoleEntity;
import com.example.CommunicationsManagement.entity.UserEntity;
import com.example.CommunicationsManagement.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {

    @Query("select userRole.user from UserRoleEntity userRole where userRole.id = :id")
    List<UserEntity> findUsersFromRoleById(Long id);

    @Transactional
    int deleteByRoleAndUser(RoleEntity roleId, UserEntity userId);

}