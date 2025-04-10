package com.ecomeerce.rest_api.projection;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.math.BigDecimal;
import java.util.UUID;

@JsonPropertyOrder({"id", "width", "height", "length", "weight", "insuranceValue", "quantity"})
public interface ProductCharacteristicsProjection {
    UUID getId();
    BigDecimal getWidth();
    BigDecimal getHeight();
    BigDecimal getLength();
    BigDecimal getWeight();
    BigDecimal getInsuranceValue();
    Integer getQuantity();
}
