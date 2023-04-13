package com.example.CommunicationsManagement.repository;

import com.example.CommunicationsManagement.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
    @Modifying
    @Transactional
    int deleteByDepartmentId(Long id);
}
