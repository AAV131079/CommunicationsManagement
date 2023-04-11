package com.example.CommunicationsManagement.controller;

import com.example.CommunicationsManagement.entity.handbook.CommunicationTypeEntity;
import com.example.CommunicationsManagement.entity.handbook.SendChannelTypeEntity;
import com.example.CommunicationsManagement.repository.CommunicationTypeRepository;
import com.example.CommunicationsManagement.repository.SendChannelTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/send_channel_types")
public class SendChannelTypeController {

    private final SendChannelTypeRepository sendChannelTypeRepository;

    @Autowired
    public SendChannelTypeController(SendChannelTypeRepository sendChannelTypeRepository) {
        this.sendChannelTypeRepository = sendChannelTypeRepository;
    }

    @GetMapping
    public List<SendChannelTypeEntity> communicationTypesList() {
        return sendChannelTypeRepository.findAll();
    }

    @GetMapping("{id}")
    public SendChannelTypeEntity getSendChannelType(@PathVariable Long id) {
        return null;
    }

    @PostMapping
    public SendChannelTypeEntity createSendChannelType(@RequestBody SendChannelTypeEntity sendChannelType) {
        return sendChannelTypeRepository.save(sendChannelType);
    }

    @PutMapping("{id}")
    public SendChannelTypeEntity updateSendChannelType(@PathVariable Long id, @RequestBody SendChannelTypeEntity sendChannelType) {
        return sendChannelTypeRepository.save(sendChannelType);
    }

}