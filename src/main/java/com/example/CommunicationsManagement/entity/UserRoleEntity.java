package com.example.CommunicationsManagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "user_role")
public class UserRoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(nullable = false, name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserEntity user;

    @OneToOne
    @JoinColumn(nullable = false, name = "role_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private RoleEntity role;

    public UserRoleEntity() {
    }

    public UserRoleEntity(UserEntity user, RoleEntity role) {
        this.setUser(user);
        this.setRole(role);
    }
}
