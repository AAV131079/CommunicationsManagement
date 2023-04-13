package com.example.CommunicationsManagement.repository;

import com.example.CommunicationsManagement.entity.CommunicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CommunicationRepository extends JpaRepository<CommunicationEntity, Long> {
    @Modifying
    @Transactional
    int deleteByCommunicationId(Long id);
}
