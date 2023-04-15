package com.example.CommunicationsManagement.repository;

import com.example.CommunicationsManagement.entity.handbook.SendChannelTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SendChannelTypeRepository extends JpaRepository<SendChannelTypeEntity, Long> {

    @Transactional
    int deleteBySendChannelTypeId(Long id);
}