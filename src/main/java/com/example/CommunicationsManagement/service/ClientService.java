package com.example.CommunicationsManagement.service;

import com.example.CommunicationsManagement.entity.ClientEntity;
import com.example.CommunicationsManagement.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<ClientEntity> findAll() {
        return clientRepository.findAll();
    }

    public Optional<ClientEntity> findById(Long id) {
        return clientRepository.findById(id);
    }

    public ClientEntity save(ClientEntity client) {
        return clientRepository.save(client);
    }

    public ClientEntity update(Long id, ClientEntity client) {
        ClientEntity existingClient = clientRepository.findById(id).orElseThrow();
        existingClient.setFirstName(client.getFirstName());
        existingClient.setLastName(client.getLastName());
        existingClient.setBirthDate(client.getBirthDate());
        existingClient.setBooking(client.getBooking());
        existingClient.setCommunication(client.getCommunication());
        return clientRepository.save(existingClient);
    }
}
