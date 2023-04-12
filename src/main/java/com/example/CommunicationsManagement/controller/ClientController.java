package com.example.CommunicationsManagement.controller;

import com.example.CommunicationsManagement.entity.ClientEntity;
import com.example.CommunicationsManagement.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<ClientEntity> clientsList() {
        return clientService.findAll();
    }

    @GetMapping("{id}")
    public ClientEntity getClient(@PathVariable Long id) {
        Optional<ClientEntity> client = clientService.findById(id);
        return client.orElse(null);
    }

    @PostMapping("/add")
    public ClientEntity createClient(@RequestBody ClientEntity client) {
        return clientService.save(client);
    }

    @PutMapping("/edit/{id}")
    public ClientEntity updateClient(@PathVariable Long id, @RequestBody ClientEntity client) {
        return clientService.update(id, client);
    }

}