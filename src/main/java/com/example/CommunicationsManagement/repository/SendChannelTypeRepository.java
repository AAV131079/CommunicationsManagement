package com.example.CommunicationsManagement.repository;

import com.example.CommunicationsManagement.entity.handbook.SendChannelTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SendChannelTypeRepository extends JpaRepository<SendChannelTypeEntity, Long> {
}
