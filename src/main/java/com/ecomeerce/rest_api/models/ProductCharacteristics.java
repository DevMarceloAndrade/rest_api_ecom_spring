package com.ecomeerce.rest_api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JoinColumn(name = "product_id", referencedColumnName = "id_", nullable = false)
    private Product product;

    @Column(nullable = false, length = 4)
    private BigDecimal width;

    @Column(nullable = false, length = 4)
    private BigDecimal height;

    @Column(nullable = false, length = 4)
    private BigDecimal length;

    @Column(nullable = false, length = 4)
    private BigDecimal weight;

    @Column(nullable = false, length = 4)
    private BigDecimal insurance_value;

    @Column(nullable = false, length = 4)
    private Integer quantity;

    public ProductCharacteristics() {
    }
}
