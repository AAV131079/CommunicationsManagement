package com.example.CommunicationsManagement.repository;

import com.example.CommunicationsManagement.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUserName(String userName);

    @Transactional
    int deleteByUserId(Long id);

    @Query("select user from UserEntity user where user.department.departmentId = :id")
    List<UserEntity> findAllUsersInDepartment(Long id);

    UserEntity findByUserId(Long id);

}