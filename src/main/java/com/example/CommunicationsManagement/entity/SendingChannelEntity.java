package com.example.CommunicationsManagement.entity;

import com.example.CommunicationsManagement.entity.handbook.SendChannelTypeEntity;
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
@Table(name = "sending_channel")
public class SendingChannelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, name = "sending_channel_id")
    private Long sendingChannelId;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, name = "create_time")
    private Date createTime;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, name = "update_time")
    private Date updateTime;

    @OneToOne
    @JoinColumn(name = "send_channel_type_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private SendChannelTypeEntity sendChannelType;
    @ManyToOne
    @JoinColumn(name = "rule_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private RuleEntity rule;

    public SendingChannelEntity() {
    }
}