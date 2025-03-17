package com.ecomeerce.rest_api.models;

import com.ecomeerce.rest_api.component.FileIdToFileConverter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
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
    @OneToMany(mappedBy = "promotion", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ProductPromotion> products_promotion = new HashSet<>();

    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "thumbnail_id")
    @JsonDeserialize(converter = FileIdToFileConverter.class)
    private File thumbnail;

    public Promotion() {
    }
}
