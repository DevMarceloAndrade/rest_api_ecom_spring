package com.ecomeerce.rest_api.projection;



import java.math.BigDecimal;

public interface ProductProjection {
    String getName();
    String getDescription();
    BigDecimal getPrice();
    Integer getIn_stock();
    Boolean getFeatured();
    Boolean getPromotion();
    FileProjection getThumbnail();
}
