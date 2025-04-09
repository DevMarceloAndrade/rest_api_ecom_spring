package com.ecomeerce.rest_api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class CompanyInformation extends DataBaseModel {

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String cnpj;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 14)
    private String phone;

    @Column(name = "phone_link", nullable = false, length = 100)
    private String phoneLink;

    @Column(nullable = false, length = 100)
    private String address;

    @Column(name = "address_link", nullable = false, length = 100)
    private String addressLink;

    @Column(name = "instagram_link", nullable = false, length = 100)
    private String instagramLink;

    public CompanyInformation() {
    }
}
