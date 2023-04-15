package com.example.CommunicationsManagement.entity;

import com.example.CommunicationsManagement.entity.handbook.CommunicationTypeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "communication")
public class CommunicationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, name = "communication_id")
    private Long communicationId;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, name = "create_time")
    private Date createTime;

    @OneToOne
    @JoinColumn(name = "communication_type_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private CommunicationTypeEntity communicationType;
    @OneToOne
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name = "booking_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private BookingEntity booking;

    @Column(columnDefinition="TEXT", name = "content")
    private String content;
    @Column(name = "description")
    private String description;

    public CommunicationEntity() {
    }
}