package com.example.CommunicationsManagement.entity;

import com.example.CommunicationsManagement.entity.handbook.RoleEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "usr")
public class UserEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, name = "user_id")
    private Long userId;
    @Column(nullable = false, name = "first_name")
    private String firstName;
    @Column(nullable = false, name = "last_name")
    private String lastName;
    @Column(nullable = false, name = "birth_date")
    private Date birthDate;
    @Column(nullable = false, unique = true, name = "user_name")
    private String userName;
    @Column(nullable = false, name = "password")
    private String password;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, name = "create_time")
    private Date createTime;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, name = "update_time")
    private Date updateTime;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private List<RoleEntity> roles = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "department_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private DepartmentEntity department;
    @OneToOne
    @JoinColumn(name = "social_media_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private SocialMediaEntity socialMedia;

    public UserEntity() {
    }

    @Override
    public String toString() {
        return String.join(" ", getLastName(), getFirstName());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}