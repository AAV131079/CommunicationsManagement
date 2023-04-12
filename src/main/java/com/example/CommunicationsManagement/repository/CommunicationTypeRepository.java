package com.example.CommunicationsManagement.repository;

import com.example.CommunicationsManagement.entity.handbook.CommunicationTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunicationTypeRepository extends JpaRepository<CommunicationTypeEntity, Long> {
}
