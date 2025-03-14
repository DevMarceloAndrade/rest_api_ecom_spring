package com.ecomeerce.rest_api.models;

import com.ecomeerce.rest_api.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.ColumnDefault;

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
    @ColumnDefault("'USER'")
    private UserRole role;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Address> addresses = new HashSet<>();

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "favorites",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> favorites = new HashSet<>();

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Review> reviews = new HashSet<>();

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Purchase> purchases = new HashSet<>();

    public User() {
    }
}
