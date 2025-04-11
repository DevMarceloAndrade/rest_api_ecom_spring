package com.ecomeerce.rest_api.projections;

import java.math.BigDecimal;
import java.util.UUID;

public interface ProductPurchasedProjection {
    UUID getId();
    String getProductName();
    Integer getQuantity();
    BigDecimal getPriceAtPurchase();
}
