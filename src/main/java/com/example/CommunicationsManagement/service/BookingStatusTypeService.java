package com.example.CommunicationsManagement.service;

import com.example.CommunicationsManagement.entity.handbook.BookingStatusTypeEntity;
import com.example.CommunicationsManagement.repository.BookingStatusTypeRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookingStatusTypeService {

    private final BookingStatusTypeRepository bookingStatusTypeRepository;

    public BookingStatusTypeService(BookingStatusTypeRepository bookingStatusTypeRepository) {
        this.bookingStatusTypeRepository = bookingStatusTypeRepository;
    }

    public List<BookingStatusTypeEntity> findAll() {
        return bookingStatusTypeRepository.findAll();
    }

    public Optional<BookingStatusTypeEntity> findById(Long id) {
        return bookingStatusTypeRepository.findById(id);
    }

    public BookingStatusTypeEntity save(BookingStatusTypeEntity bookingStatusType) {
        return bookingStatusTypeRepository.save(bookingStatusType);
    }

}