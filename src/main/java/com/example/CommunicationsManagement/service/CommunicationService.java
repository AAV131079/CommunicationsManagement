package com.example.CommunicationsManagement.service;

import com.example.CommunicationsManagement.entity.CommunicationEntity;
import com.example.CommunicationsManagement.repository.CommunicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommunicationService {

    private final CommunicationRepository communicationRepository;

    public CommunicationService(CommunicationRepository communicationRepository) {
        this.communicationRepository = communicationRepository;
    }

    public List<CommunicationEntity> findAll() {
        return communicationRepository.findAll();
    }

    public Optional<CommunicationEntity> findById(Long id) {
        return communicationRepository.findById(id);
    }

    public CommunicationEntity save(CommunicationEntity communication) {
        return communicationRepository.save(communication);
    }

    public int deleteById(Long id) {
        return communicationRepository.deleteByCommunicationId(id);
    }

}