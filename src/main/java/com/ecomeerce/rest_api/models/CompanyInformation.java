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

    @Column(nullable = false, length = 100)
    private String phone_link;

    @Column(nullable = false, length = 100)
    private String address;

    @Column(nullable = false, length = 100)
    private String address_link;

    @Column(nullable = false, length = 100)
    private String instagram_link;

    public CompanyInformation() {
    }
}
