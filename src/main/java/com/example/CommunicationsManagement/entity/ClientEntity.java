package com.example.CommunicationsManagement.entity;

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
@Table(name = "client")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, name = "client_id")
    private Long clientId;
    @Column(nullable = false, name = "first_name")
    private String firstName;
    @Column(nullable = false, name = "last_name")
    private String lastName;
    @Column(nullable = false, name = "birth_date")
    private Date birthDate;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, name = "create_time")
    private Date createTime;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, name = "update_time")
    private Date updateTime;
    @Column(nullable = false, name = "available")
    private Boolean available;

    @OneToOne
    @JoinColumn(name = "social_media_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private SocialMediaEntity socialMedia;
    @ManyToOne
    @JoinColumn(name = "communication_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private CommunicationEntity communication;
    @ManyToOne
    @JoinColumn(name = "booking_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private BookingEntity booking;

    public ClientEntity() {
    }
}