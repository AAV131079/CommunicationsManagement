package com.example.CommunicationsManagement.controller;

import com.example.CommunicationsManagement.entity.handbook.CommunicationTypeEntity;
import com.example.CommunicationsManagement.service.CommunicationTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/communication_types")
public class CommunicationTypeController {

    private final CommunicationTypeService communicationTypeService;

    @Autowired
    public CommunicationTypeController(CommunicationTypeService communicationTypeService) {
        this.communicationTypeService = communicationTypeService;
    }

    @GetMapping
    public List<CommunicationTypeEntity> communicationTypesList() {
        return communicationTypeService.findAll();
    }

    @GetMapping("{id}")
    public CommunicationTypeEntity getCommunicationType(@PathVariable Long id) {
        return communicationTypeService.findById(id).orElseThrow();
    }

    @PostMapping("/add")
    public CommunicationTypeEntity createCommunicationType(@RequestBody CommunicationTypeEntity communicationType) {
        return communicationTypeService.save(communicationType);
    }

    @PutMapping("/edit/{id}")
    public CommunicationTypeEntity updateCommunicationType(@PathVariable Long id, @RequestBody CommunicationTypeEntity communicationType) {
        CommunicationTypeEntity existingCommunicationType = communicationTypeService.findById(id).orElseThrow();
        BeanUtils.copyProperties(communicationType, existingCommunicationType, "communicationTypeId", "createTime", "updateTime");
        return communicationTypeService.save(existingCommunicationType);
    }

}