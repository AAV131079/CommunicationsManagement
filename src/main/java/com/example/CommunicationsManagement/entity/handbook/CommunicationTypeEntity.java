package com.example.CommunicationsManagement.entity.handbook;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "communication_type")
public class CommunicationTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, name = "communication_type_id")
    private Long communicationTypeId;
    @Column(nullable = false, name = "name")
    private String name;
    @Column(nullable = false, name = "description")
    private String description;

    public CommunicationTypeEntity() {
    }
}
