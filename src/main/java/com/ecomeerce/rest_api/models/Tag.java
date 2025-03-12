package com.ecomeerce.rest_api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Tag extends DataBaseModel {

    @Column(nullable = false, length = 20)
    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(mappedBy = "sub_category_tags",fetch = FetchType.LAZY)
    private SubCategory subCategory;

    public Tag() {
    }
}
