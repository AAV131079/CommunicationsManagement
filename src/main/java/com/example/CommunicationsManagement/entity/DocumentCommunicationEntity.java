package com.example.CommunicationsManagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "document_communication")
public class DocumentCommunicationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(nullable = false, name = "document_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private DocumentEntity document;

    @OneToOne
    @JoinColumn(nullable = false, name = "communication_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CommunicationEntity communication;

    public DocumentCommunicationEntity() {
    }
}
