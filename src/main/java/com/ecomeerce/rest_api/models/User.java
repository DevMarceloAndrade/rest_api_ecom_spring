package com.ecomeerce.rest_api.models;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tab_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer id;
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


}
