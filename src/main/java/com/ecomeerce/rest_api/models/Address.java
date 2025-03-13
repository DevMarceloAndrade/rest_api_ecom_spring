package com.ecomeerce.rest_api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Address extends DataBaseModel {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id_", nullable = false)
    private User user;

    @Column(nullable = false, length = 8)
    private String cep;

    @Column(nullable = false, length = 2)
    private String state;

    @Column(nullable = false, length = 100)
    private String city;

    @Column(nullable = false, length = 50)
    private String neighborhood;

    @Column(nullable = false, length = 100)
    private String street;

    @Column(nullable = false, length = 10, columnDefinition = "VARCHAR(10) default 'S/N'")
    private String house_number;

    @Column(nullable = false, length = 20)
    private String complement;

    @Column(nullable = true)
    private String reference_point;

    @Column(nullable = false, columnDefinition = "BOOLEAN default 'true'")
    private Boolean active;

    public Address() {
    }
}
