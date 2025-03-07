package com.ecomeerce.rest_api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Promotion extends DataBaseModel{

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String description;

    @Column(nullable = false, columnDefinition = "BOOLEAN default 'false'")
    private Boolean featured;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "promotion", fetch = FetchType.LAZY)
    private Set<ProductPromotion> productsPromotion = new HashSet<>();

    public Promotion() {
    }
}
