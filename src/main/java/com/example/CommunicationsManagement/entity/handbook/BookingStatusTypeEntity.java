package com.example.CommunicationsManagement.entity.handbook;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "booking_status_type")
public class BookingStatusTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, name = "booking_status_type_id")
    private Long bookingStatusTypeId;
    @Column(nullable = false, name = "name")
    private String name;
    @Column(nullable = false, name = "description")
    private String description;

    public BookingStatusTypeEntity() {
    }
}