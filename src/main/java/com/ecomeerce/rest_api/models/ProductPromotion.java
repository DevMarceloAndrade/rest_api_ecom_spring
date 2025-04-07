package com.ecomeerce.rest_api.models;

import com.ecomeerce.rest_api.component.ProductIdToEntityConverter;
import com.ecomeerce.rest_api.component.PromotionIdToEntityConverter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class ProductPromotion extends DataBaseModel{

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column
    private String description;

    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "promotion_id", referencedColumnName = "id_")
    @JsonDeserialize(converter = PromotionIdToEntityConverter.class)
    private Promotion promotion;

    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", referencedColumnName = "id_")
    @JsonDeserialize(converter = ProductIdToEntityConverter.class)
    private Product product;

    public ProductPromotion() {
    }

    @PreRemove
    private void preRemove(){
        if(promotion!=null) setPromotion(null);
        if (product != null) setProduct(null);
    }
}
