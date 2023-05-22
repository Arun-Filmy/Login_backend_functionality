package com.LoginFunctionalityWork.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "forget_user_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserForget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_detail")
    private String name;
    @Column(unique = true, name = "email_detail")
    private String email;
    @Column(name = "password_detail")
    private String password;
    @Column(name = "token")
    private String token;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime tokenCreationDate;


}
