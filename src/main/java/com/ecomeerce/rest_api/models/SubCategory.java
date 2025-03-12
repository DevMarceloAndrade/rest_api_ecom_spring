package com.ecomeerce.rest_api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class SubCategory extends DataBaseModel {

    @Column(nullable = false, length = 100)
    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id_")
    private Category category;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "sub_category", fetch = FetchType.LAZY)
    private Set<Product> products = new HashSet<>();

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "sub_category_tags",
            joinColumns = @JoinColumn(name = "sub_category_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_type_id")
    )
    private Set<TagType> tags = new HashSet<>();

    public SubCategory() {
    }
}
