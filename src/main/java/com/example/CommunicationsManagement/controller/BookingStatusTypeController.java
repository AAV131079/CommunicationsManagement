package com.example.CommunicationsManagement.controller;

import com.example.CommunicationsManagement.entity.handbook.BookingStatusTypeEntity;
import com.example.CommunicationsManagement.entity.handbook.CommunicationTypeEntity;
import com.example.CommunicationsManagement.service.BookingStatusTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking_types")
@Api("Методы обработки типов статуса бронирования коммуникаций")
public class BookingStatusTypeController {

    private final BookingStatusTypeService bookingStatusTypeService;

    @Autowired
    public BookingStatusTypeController(BookingStatusTypeService bookingStatusTypeService) {
        this.bookingStatusTypeService = bookingStatusTypeService;
    }

    @GetMapping
    @ApiOperation("Выгрузка всех типов бронирования")
    public List<BookingStatusTypeEntity> communicationTypesList() {
        return bookingStatusTypeService.findAll();
    }

    @GetMapping("{id}")
    @ApiOperation("Выгрузка типа бронирования по id")
    public BookingStatusTypeEntity getCommunicationType(@PathVariable Long id) {
        return bookingStatusTypeService.findById(id).orElseThrow();
    }

    @PostMapping("/add")
    @ApiOperation("Добавление нового типа бронирования")
    public BookingStatusTypeEntity createCommunicationType(@RequestBody BookingStatusTypeEntity bookingStatusType) {
        return bookingStatusTypeService.save(bookingStatusType);
    }

    @PutMapping("/edit/{id}")
    @ApiOperation("Обновление типа бронирования по id")
    public BookingStatusTypeEntity updateCommunicationType(@PathVariable Long id, @RequestBody CommunicationTypeEntity communicationType) {
        BookingStatusTypeEntity existingCommunicationType = bookingStatusTypeService.findById(id).orElseThrow();
        BeanUtils.copyProperties(communicationType, existingCommunicationType, "bookingStatusTypeId", "createTime", "updateTime");
        return bookingStatusTypeService.save(existingCommunicationType);
    }

}