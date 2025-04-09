package com.ecomeerce.rest_api.models;

import com.ecomeerce.rest_api.component.CategoryIdToEntityConverter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class SubCategory extends DataBaseModel {

    @Column(nullable = false, length = 100)
    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", referencedColumnName = "id_", nullable = false)
    @JsonDeserialize(converter = CategoryIdToEntityConverter.class)
    private Category category;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "subCategory", fetch = FetchType.LAZY)
    private List<Product> products;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "sub_category_tags",
            joinColumns = @JoinColumn(name = "sub_category_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_type_id")
    )
    private List<TagType> tags;

    public SubCategory() {
    }
}
