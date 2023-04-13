package com.example.CommunicationsManagement.controller;

import com.example.CommunicationsManagement.entity.CommunicationEntity;
import com.example.CommunicationsManagement.entity.handbook.SendChannelTypeEntity;
import com.example.CommunicationsManagement.service.CommunicationService;
import com.example.CommunicationsManagement.service.SendChannelTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/communications")
@Api("Методы обработки коммуникаций")
public class CommunicationController {

    private final CommunicationService communicationService;

    @Autowired
    public CommunicationController(CommunicationService communicationService) {
        this.communicationService = communicationService;
    }

    @GetMapping
    @ApiOperation("Выгрузка списка доступных коммуникаций")
    public List<CommunicationEntity> communicationsList() {
        return communicationService.findAll();
    }

    @GetMapping("{id}")
    @ApiOperation("Выгрузка коммуникации по id")
    public CommunicationEntity getCommunication(@PathVariable Long id) {
        return communicationService.findById(id).orElseThrow();
    }

    @PostMapping("/add")
    @ApiOperation("Добавление коммуникации")
    public CommunicationEntity createCommunication(@RequestBody CommunicationEntity communication) {
        return communicationService.save(communication);
    }

    @PutMapping("/edit/{id}")
    @ApiOperation("Обновление данных коммуникации по id")
    public CommunicationEntity updateCommunication(@PathVariable Long id, @RequestBody CommunicationEntity communication) {
        CommunicationEntity existingCommunication = communicationService.findById(id).orElseThrow();
        BeanUtils.copyProperties(communication, existingCommunication, "communicationId", "createTime", "updateTime");
        return communicationService.save(existingCommunication);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Удаление коммуникации по id")
    public ResponseEntity<String> deleteCommunication(@PathVariable Long id) {
        communicationService.deleteById(id);
        return new ResponseEntity<>("{\"response\":\"Коммуникация успешно удалена\",\"id\":\"" + id + "\"}", HttpStatus.OK);
    }

}