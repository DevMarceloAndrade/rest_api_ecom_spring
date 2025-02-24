package com.ecomeerce.rest_api.models;

import com.ecomeerce.rest_api.roles.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import pro.handler.file.vo.v1.UploadFileResponseVO;

import java.sql.Date;
import java.time.LocalDateTime;

@Getter
@Setter
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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;

    @CreationTimestamp
    @Column(updatable = false,nullable = false)
    private LocalDateTime created_at;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime updated_at;

    public User() {

    }
}
