package com.LoginFunctionalityWork.entity;

import jakarta.persistence.*;
import lombok.*;

import java.security.Timestamp;

@Entity
@Table(name = "user_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    @Column(name = "email_detail", nullable = false, unique = true)
    private String email;
    @Column(name = "password_detail", nullable = false)
    private String password;
    @Column(name = "is_enabled")
    private boolean isEnabled;
    @Column(name = "last_login_detail", columnDefinition = "TIMESTAMP")
    private String lastLogin;
    @Column(name = "partner_id")
    private long partnerId;
}
