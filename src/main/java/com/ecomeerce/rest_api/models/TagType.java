package com.ecomeerce.rest_api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class TagType extends DataBaseModel {

    @Column(nullable = false, length = 20)
    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(mappedBy = "tags",fetch = FetchType.LAZY)
    private List<SubCategory> subCategory;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "tagType",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Tag> tags;

    public TagType() {
    }
}
