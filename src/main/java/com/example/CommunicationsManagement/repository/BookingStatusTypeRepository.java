package com.example.CommunicationsManagement.repository;

import com.example.CommunicationsManagement.entity.handbook.BookingStatusTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface BookingStatusTypeRepository extends JpaRepository<BookingStatusTypeEntity, Long> {

    BookingStatusTypeEntity findByName(String booked);

    @Transactional
    int deleteByBookingStatusTypeId(Long id);

}