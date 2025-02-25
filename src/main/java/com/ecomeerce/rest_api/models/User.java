package com.ecomeerce.rest_api.models;

import com.ecomeerce.rest_api.roles.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name="tab_user")
public class User extends DataBaseModel {

    @Column(length = 50, nullable = false)
    private String first_name;

    @Column(length = 20, nullable = false)
    private String last_name;

    @Column(length = 11, nullable = false)
    private Integer phone;

    @Column(nullable = false)
    private Date birth;

    @Column(length = 50,nullable = false, unique = true)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;

    public User() {

    }
}
