package com.example.CommunicationsManagement.repository;

import com.example.CommunicationsManagement.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
}
