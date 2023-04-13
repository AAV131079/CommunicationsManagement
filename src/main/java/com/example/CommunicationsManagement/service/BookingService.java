package com.example.CommunicationsManagement.service;

import com.example.CommunicationsManagement.entity.BookingEntity;
import com.example.CommunicationsManagement.entity.handbook.BookingStatusTypeEntity;
import com.example.CommunicationsManagement.repository.BookingRepository;
import com.example.CommunicationsManagement.repository.BookingStatusTypeRepository;
import org.hibernate.PropertyValueException;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final BookingStatusTypeRepository bookingStatusTypeRepository;

    public BookingService(BookingRepository bookingRepository, BookingStatusTypeRepository bookingStatusTypeRepository) {
        this.bookingRepository = bookingRepository;
        this.bookingStatusTypeRepository = bookingStatusTypeRepository;
    }

    public BookingEntity save(BookingEntity bookingEntity) {
        return bookingRepository.save(bookingEntity);
    }

    public BookingEntity add(Date beforeDate, String status) {
        BookingEntity bookingEntity = new BookingEntity();
        BookingStatusTypeEntity bookingStatus = bookingStatusTypeRepository.findByName(status);
        if (bookingStatus == null) {
            throw new PropertyValueException("wrong property", "status", "name");
        }
        bookingEntity.setStatus(bookingStatus);
        bookingEntity.setBeforeDate(beforeDate);
        bookingRepository.save(bookingEntity);
        return bookingEntity;
    }

}