package com.ecomeerce.rest_api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Product extends DataBaseModel {

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = true)
    private String description;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer in_stock;

    @Column(nullable = false, columnDefinition = "BOOLEAN default 'false'")
    private Boolean featured;

    @Column(nullable = false, columnDefinition = "BOOLEAN default 'false'")
    private Boolean promotion;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sub_category_id", referencedColumnName = "id_")
    private SubCategory subCategory;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private ProductPromotion productPromotion;

    public Product() {
    }
}
