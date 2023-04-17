package com.example.CommunicationsManagement.repository;

import com.example.CommunicationsManagement.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {

    @Transactional
    int deleteByCompanyId(Long id);

}
