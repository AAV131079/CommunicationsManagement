package com.example.CommunicationsManagement.repository;

import com.example.CommunicationsManagement.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity,Long> {

    @Transactional
    int deleteByRoleId(Long id);

    RoleEntity findByRoleId(Long id);

}