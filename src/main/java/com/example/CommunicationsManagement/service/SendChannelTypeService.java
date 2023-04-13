package com.example.CommunicationsManagement.service;

import com.example.CommunicationsManagement.entity.handbook.SendChannelTypeEntity;
import com.example.CommunicationsManagement.repository.SendChannelTypeRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SendChannelTypeService {

    private final SendChannelTypeRepository sendChannelTypeRepository;

    public SendChannelTypeService(SendChannelTypeRepository sendChannelTypeRepository) {
        this.sendChannelTypeRepository = sendChannelTypeRepository;
    }

    public List<SendChannelTypeEntity> findAll() {
        return sendChannelTypeRepository.findAll();
    }

    public Optional<SendChannelTypeEntity> findById(Long id) {
        return sendChannelTypeRepository.findById(id);
    }

    public SendChannelTypeEntity save(SendChannelTypeEntity sendChannelType) {
        return sendChannelTypeRepository.save(sendChannelType);
    }

    public int deleteById(Long id) {
        return sendChannelTypeRepository.deleteBySendChannelTypeId(id);
    }

}