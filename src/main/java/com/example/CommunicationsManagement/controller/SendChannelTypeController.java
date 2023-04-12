package com.example.CommunicationsManagement.controller;

import com.example.CommunicationsManagement.entity.handbook.SendChannelTypeEntity;
import com.example.CommunicationsManagement.service.SendChannelTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/send_channel_types")
public class SendChannelTypeController {

    private final SendChannelTypeService sendChannelTypeService;

    @Autowired
    public SendChannelTypeController(SendChannelTypeService sendChannelTypeService) {
        this.sendChannelTypeService = sendChannelTypeService;
    }

    @GetMapping
    public List<SendChannelTypeEntity> communicationTypesList() {
        return sendChannelTypeService.findAll();
    }

    @GetMapping("{id}")
    public SendChannelTypeEntity getSendChannelType(@PathVariable Long id) {
        return sendChannelTypeService.findById(id).orElseThrow();
    }

    @PostMapping("/add")
    public SendChannelTypeEntity createSendChannelType(@RequestBody SendChannelTypeEntity sendChannelType) {
        return sendChannelTypeService.save(sendChannelType);
    }

    @PutMapping("/edit/{id}")
    public SendChannelTypeEntity updateSendChannelType(@PathVariable Long id, @RequestBody SendChannelTypeEntity sendChannelType) {
        SendChannelTypeEntity existingSendChannelType = sendChannelTypeService.findById(id).orElseThrow();
        BeanUtils.copyProperties(sendChannelType, existingSendChannelType, "sendChannelTypeId", "createTime", "updateTime");

        return sendChannelTypeService.save(existingSendChannelType);
    }

}