package com.example.CommunicationsManagement.service;

import com.example.CommunicationsManagement.entity.BookingEntity;
import com.example.CommunicationsManagement.entity.ClientEntity;
import com.example.CommunicationsManagement.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final BookingService bookingService;

    public ClientService(ClientRepository clientRepository, BookingService bookingService) {
        this.clientRepository = clientRepository;
        this.bookingService = bookingService;
    }

    public List<ClientEntity> findAll() {
        return clientRepository.findAll();
    }

    public List<ClientEntity> findByAvailable(boolean available) {
        return clientRepository.findByAvailable(available);
    }

    public Optional<ClientEntity> findById(Long id) {
        return clientRepository.findById(id);
    }

    public ClientEntity save(ClientEntity client) {
        if (client.getAvailable() == null) {
            client.setAvailable(true);
        }
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

    @Transactional
    public ClientEntity bookingClient(Long id, BookingEntity booking) {
        ClientEntity client = clientRepository.findById(id).orElseThrow();
        BookingEntity newBooking = bookingService.add(booking.getBeforeDate(), booking.getStatus().getName());
        client.setBooking(newBooking);
        return client;
    }
}
