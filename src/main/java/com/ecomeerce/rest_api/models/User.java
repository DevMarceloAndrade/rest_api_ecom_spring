package com.ecomeerce.rest_api.models;

import com.ecomeerce.rest_api.roles.UserRole;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
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
    private LocalDate birth;

    @Column(length = 50,nullable = false, unique = true)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Address> addresses = new HashSet<>();

    public User() {

    }
}
