package com.ecomeerce.rest_api.models;

import com.ecomeerce.rest_api.component.FileIdToFileConverter;
import com.ecomeerce.rest_api.component.SubCategoryIdToEntityConverter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Product extends DataBaseModel {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sub_category_id", referencedColumnName = "id_", nullable = false)
    @JsonDeserialize(converter = SubCategoryIdToEntityConverter.class)
    private SubCategory sub_category;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = true)
    private String description;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer in_stock;

    @Column(nullable = false)
    private Boolean featured;

    @Column(nullable = false)
    private Boolean promotion;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "thumbnail_id")
    @JsonDeserialize(converter = FileIdToFileConverter.class)
    private File thumbnail;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "product_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<File> files;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ProductCharacteristics characteristics;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ProductPromotion product_promotion;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(mappedBy = "favorites", fetch = FetchType.LAZY)
    private List<User> favorites_by_user;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Review> reviews;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
    private List<Tag> tags;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<ProductPurchased> productsPurchased;

    public Product() {
    }

    @PrePersist
    public void preCreateOrUpdate(){
        if (promotion == null)promotion = false;
        if (featured == null) featured = false;
    }
}
