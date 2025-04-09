package com.ecomeerce.rest_api.models;

import com.ecomeerce.rest_api.component.ProductIdToEntityConverter;
import com.ecomeerce.rest_api.component.SubCategoryIdToEntityConverter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class ProductCharacteristics extends DataBaseModel{

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, optional = false)
    @JoinColumn(name = "product_id", referencedColumnName = "id_", nullable = false, updatable = false)
    @JsonDeserialize(converter = ProductIdToEntityConverter.class)
    private Product product;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal width;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal height;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal length;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal weight;

    @Column(name = "insurance_value", nullable = false, precision = 10, scale = 2)
    private BigDecimal insuranceValue;

    @Column(nullable = false)
    private Integer quantity;

    public ProductCharacteristics() {
    }

    @PreRemove
    public void preRemove(){
        if(product != null)setProduct(null);
    }
}
