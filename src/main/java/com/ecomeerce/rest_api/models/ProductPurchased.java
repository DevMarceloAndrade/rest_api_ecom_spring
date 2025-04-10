package com.ecomeerce.rest_api.models;

import com.ecomeerce.rest_api.component.ProductIdToEntityConverter;
import com.ecomeerce.rest_api.component.PurchaseIdToEntityConverter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class ProductPurchased extends DataBaseModel{

    @Column(name = "product_name", updatable = false)
    private String productName;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "purchase_id", referencedColumnName = "id_" ,nullable = false, updatable = false)
    @JsonDeserialize(converter = PurchaseIdToEntityConverter.class)
    private Purchase purchase;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", referencedColumnName = "id_", nullable = false, updatable = false)
    @JsonDeserialize(converter = ProductIdToEntityConverter.class)
    private Product product;

    @Column(nullable = false, updatable = false)
    private Integer quantity;

    @Column(name = "price_at_purchase", nullable = false, precision = 10, scale = 2, updatable = false)
    private BigDecimal priceAtPurchase;

    public ProductPurchased() {
    }

    @PrePersist
    public void prePersist(){
        this.productName = product.getName();
        this.priceAtPurchase = product.getPrice();
    }
}
