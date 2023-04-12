package com.example.CommunicationsManagement.repository;

import com.example.CommunicationsManagement.entity.handbook.BookingStatusTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingStatusTypeRepository extends JpaRepository<BookingStatusTypeEntity, Long> {

    BookingStatusTypeEntity findByName(String booked);
}