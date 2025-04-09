package com.ecomeerce.rest_api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Tag extends DataBaseModel{

    @Column(nullable = false, length = 20)
    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tag_type_id", referencedColumnName = "id_", nullable = false)
    private TagType tagType;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "product_tag",
            joinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id_"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id_")
    )
    private List<Product> products;

    public Tag() {
    }
}
