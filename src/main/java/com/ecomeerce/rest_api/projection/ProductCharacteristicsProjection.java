package com.ecomeerce.rest_api.projection;

import java.math.BigDecimal;
import java.util.UUID;

public interface ProductCharacteristicsProjection {
    UUID getId();
    BigDecimal getWidth();
    BigDecimal getHeight();
    BigDecimal getLength();
    BigDecimal getWeight();
    BigDecimal getInsurance_value();
    Integer getQuantity();
}
