package com.example.CommunicationsManagement.repository;

import com.example.CommunicationsManagement.entity.handbook.CommunicationTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CommunicationTypeRepository extends JpaRepository<CommunicationTypeEntity, Long> {

    @Transactional
    int deleteByCommunicationTypeId(Long id);
}