package com.ecomeerce.rest_api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Product extends DataBaseModel {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sub_category_id", referencedColumnName = "id_")
    private SubCategory sub_category;

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

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private ProductCharacteristics characteristics;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private ProductPromotion product_promotion;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(mappedBy = "favorites", fetch = FetchType.LAZY)
    private Set<User> favorites_by_user = new HashSet<>();

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private Set<Review> reviews = new HashSet<>();

    public Product() {
    }
}
