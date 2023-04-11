package com.example.CommunicationsManagement.controller;

import com.example.CommunicationsManagement.entity.ClientEntity;
import com.example.CommunicationsManagement.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping
    public List<ClientEntity> clientsList() {
        return clientRepository.findAll();
    }

    @GetMapping("{id}")
    public ClientEntity getClient(@PathVariable Long id) {
        return null;
    }

    @PostMapping
    public ClientEntity createClient(@RequestBody ClientEntity client) {
        return clientRepository.save(client);
    }

    @PutMapping("{id}")
    public ClientEntity updateClient(@PathVariable Long id, @RequestBody ClientEntity client) {
        return clientRepository.save(client);
    }

}