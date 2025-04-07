package com.ecomeerce.rest_api.projection;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.math.BigDecimal;
import java.util.UUID;

@JsonPropertyOrder({"id", "price", "description", "promotion", "product"})
public interface ProductPromotionProjection {
    UUID getId();
    BigDecimal getPrice();
    String getDescription();
    ProductProjection getProduct();
}
