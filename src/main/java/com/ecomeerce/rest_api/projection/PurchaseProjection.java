package com.ecomeerce.rest_api.projection;

import com.ecomeerce.rest_api.enums.PaymentStatus;
import com.ecomeerce.rest_api.enums.PaymentType;
import com.ecomeerce.rest_api.models.Address;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface PurchaseProjection {
    UUID getId();
    Address getAddress();
    PaymentType getPaymentType();
    PaymentStatus getPaymentStatus();
    String getPaymentIdMp();
    String getStatus();
    BigDecimal getShippingCost();
    BigDecimal getTotalValueProducts();
    List<ProductPurchasedProjection> getProductPurchased();
}
