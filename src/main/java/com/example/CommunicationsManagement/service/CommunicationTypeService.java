package com.example.CommunicationsManagement.service;

import com.example.CommunicationsManagement.entity.handbook.CommunicationTypeEntity;
import com.example.CommunicationsManagement.repository.CommunicationTypeRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CommunicationTypeService {

    private final CommunicationTypeRepository communicationTypeRepository;

    public CommunicationTypeService(CommunicationTypeRepository communicationTypeRepository) {
        this.communicationTypeRepository = communicationTypeRepository;
    }

    public List<CommunicationTypeEntity> findAll() {
        return communicationTypeRepository.findAll();
    }

    public Optional<CommunicationTypeEntity> findById(Long id) {
        return communicationTypeRepository.findById(id);
    }

    public CommunicationTypeEntity save(CommunicationTypeEntity communicationType) {
        return communicationTypeRepository.save(communicationType);
    }

    public int deleteById(Long id) {
        return communicationTypeRepository.deleteByCommunicationTypeId(id);
    }

}