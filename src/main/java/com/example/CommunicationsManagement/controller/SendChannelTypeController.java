package com.example.CommunicationsManagement.controller;

import com.example.CommunicationsManagement.entity.handbook.SendChannelTypeEntity;
import com.example.CommunicationsManagement.service.SendChannelTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/send_channel_types")
@Api("Методы обработки доступных каналов коммуникации")
public class SendChannelTypeController {

    private final SendChannelTypeService sendChannelTypeService;

    @Autowired
    public SendChannelTypeController(SendChannelTypeService sendChannelTypeService) {
        this.sendChannelTypeService = sendChannelTypeService;
    }

    @GetMapping
    @ApiOperation("Выгрузка списка доступных каналов коммуникации")
    public List<SendChannelTypeEntity> communicationTypesList() {
        return sendChannelTypeService.findAll();
    }

    @GetMapping("{id}")
    @ApiOperation("Выгрузка канала коммуникации по id")
    public SendChannelTypeEntity getSendChannelType(@PathVariable Long id) {
        return sendChannelTypeService.findById(id).orElseThrow();
    }

    @PostMapping("/add")
    @ApiOperation("Добавление канала коммуникации")
    public SendChannelTypeEntity createSendChannelType(@RequestBody SendChannelTypeEntity sendChannelType) {
        return sendChannelTypeService.save(sendChannelType);
    }

    @PutMapping("/edit/{id}")
    @ApiOperation("Обновление данных канала коммуникации по id")
    public SendChannelTypeEntity updateSendChannelType(@PathVariable Long id, @RequestBody SendChannelTypeEntity sendChannelType) {
        SendChannelTypeEntity existingSendChannelType = sendChannelTypeService.findById(id).orElseThrow();
        BeanUtils.copyProperties(sendChannelType, existingSendChannelType, "sendChannelTypeId", "createTime", "updateTime");
        return sendChannelTypeService.save(existingSendChannelType);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Удаление канала коммуникации по id")
    public ResponseEntity<Map<String, String>> deleteSendChannelType(@PathVariable Long id) {
        if (sendChannelTypeService.deleteById(id) >0) {
            return new ResponseEntity<>(Map.of("description", "Канал коммуникации успешно удален", "id", id.toString()), HttpStatus.OK);
        } else {
            throw new NoSuchElementException("No such element by id " + id);
        }
    }

}