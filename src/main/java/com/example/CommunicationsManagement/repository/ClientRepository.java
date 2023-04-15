package com.example.CommunicationsManagement.repository;

import com.example.CommunicationsManagement.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    List<ClientEntity> findByAvailable(boolean b);

    @Transactional
    int deleteByClientId(long id);
}