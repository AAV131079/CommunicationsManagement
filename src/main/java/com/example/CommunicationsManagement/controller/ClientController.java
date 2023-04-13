package com.example.CommunicationsManagement.controller;

import com.example.CommunicationsManagement.entity.BookingEntity;
import com.example.CommunicationsManagement.entity.ClientEntity;
import com.example.CommunicationsManagement.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/clients")
@Api("Методы обработки существующих клиентов")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    @ApiOperation("Выгрузка списка всех клиентов")
    public List<ClientEntity> clientsList() {
        return clientService.findAll();
    }

    @GetMapping("/available")
    @ApiOperation("Выгрузка всех клиентов, доступных для коммуникации")
    public List<ClientEntity> clientsListAvailable() {
        return clientService.findByAvailable(true);
    }

    @GetMapping("{id}")
    @ApiOperation("Выгрузка клиента по id")
    public ClientEntity getClient(@PathVariable Long id) {
        return clientService.findById(id).orElseThrow();
    }

    @GetMapping("/{id}/availability")
    @ApiOperation("Проверка доступности клиента для коммуникации по id")
    public ResponseEntity<Map<String, String>> checkClientAvailable(@PathVariable Long id) {
        ClientEntity client = clientService.findById(id).orElseThrow();
        Map<String, String> response = new HashMap<>();
        response.put("clientId", client.getClientId().toString());
        response.put("available", client.getAvailable().toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/add")
    @ApiOperation("Добавления нового клиента")
    public ClientEntity createClient(@RequestBody ClientEntity client) {
        return clientService.save(client);
    }

    @PutMapping("/{id}/bookings")
    @ApiOperation("Бронирование клиентов для коммуникации в будущем")
    public ClientEntity bookingClient(@PathVariable Long id, @RequestBody BookingEntity booking) {
        return clientService.bookingClient(id, booking);
    }

    @PutMapping("/edit/{id}")
    @ApiOperation("Обновление данных клиента по id")
    public ClientEntity updateClient(@PathVariable Long id, @RequestBody ClientEntity client) {
        ClientEntity existingClient = clientService.findById(id).orElseThrow();
        BeanUtils.copyProperties(client, existingClient, "clientId","createTime", "updateTime");
        return clientService.save(existingClient);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Удаление клиента по id")
    public ResponseEntity<String> deleteClient(@PathVariable Long id) {
        clientService.deleteById(id);
        return new ResponseEntity<>("{\"response\":\"Клиент успешно удален\",\"id\":\"" + id + "\"}", HttpStatus.OK);
    }

}