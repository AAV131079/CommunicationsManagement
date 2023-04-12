package com.example.CommunicationsManagement.entity.handbook;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "send_channel_type")
public class SendChannelTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, name = "send_channel_type_id")
    private Long sendChannelTypeId;
    @Column(nullable = false, name = "name")
    private String name;
    @Column(nullable = false, name = "description")
    private String description;

    public SendChannelTypeEntity() {
    }
}
