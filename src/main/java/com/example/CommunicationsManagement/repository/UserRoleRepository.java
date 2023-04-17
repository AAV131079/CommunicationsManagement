package com.example.CommunicationsManagement.repository;

import com.example.CommunicationsManagement.entity.UserEntity;
import com.example.CommunicationsManagement.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {

    @Query("select userRole.user from UserRoleEntity userRole where userRole.id = :id")
    List<UserEntity> findUsersFromRoleById(Long id);

    @Query("delete from UserRoleEntity userRole where userRole.role.roleId = :roleId and userRole.user.userId = :userId")
    int deleteRoleFromUser(Long roleId, Long userId);

}