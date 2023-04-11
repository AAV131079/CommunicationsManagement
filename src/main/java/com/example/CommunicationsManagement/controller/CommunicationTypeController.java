package com.example.CommunicationsManagement.controller;

import com.example.CommunicationsManagement.entity.ClientEntity;
import com.example.CommunicationsManagement.entity.handbook.CommunicationTypeEntity;
import com.example.CommunicationsManagement.repository.CommunicationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/communication_types")
public class CommunicationTypeController {

    private final CommunicationTypeRepository communicationTypeRepository;

    @Autowired
    public CommunicationTypeController(CommunicationTypeRepository communicationTypeRepository) {
        this.communicationTypeRepository = communicationTypeRepository;
    }

    @GetMapping
    public List<CommunicationTypeEntity> communicationTypesList() {
        return communicationTypeRepository.findAll();
    }

    @GetMapping("{id}")
    public CommunicationTypeEntity getCommunicationType(@PathVariable Long id) {
        return null;
    }

    @PostMapping
    public CommunicationTypeEntity createCommunicationType(@RequestBody CommunicationTypeEntity communicationType) {
        return communicationTypeRepository.save(communicationType);
    }

    @PutMapping("{id}")
    public CommunicationTypeEntity updateCommunicationType(@PathVariable Long id, @RequestBody CommunicationTypeEntity communicationType) {
        return communicationTypeRepository.save(communicationType);
    }

}