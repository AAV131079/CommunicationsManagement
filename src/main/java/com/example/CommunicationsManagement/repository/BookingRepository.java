package com.example.CommunicationsManagement.repository;

import com.example.CommunicationsManagement.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
    @Modifying
    @Transactional
    int deleteByBookingId(Long id);
}