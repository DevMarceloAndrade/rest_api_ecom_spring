package com.ecomeerce.rest_api.projection;

import java.math.BigDecimal;
import java.util.UUID;

public interface ProductPurchasedProjection {
    UUID getId();
    String getProductName();
    Integer getQuantity();
    BigDecimal getPriceAtPurchase();
}
