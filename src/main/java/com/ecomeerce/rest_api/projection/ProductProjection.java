package com.ecomeerce.rest_api.projection;



import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.math.BigDecimal;
import java.util.UUID;

@JsonPropertyOrder({"id", "name", "description", "price", "in_stock", "featured", "promotion", "thumbnail"})
public interface ProductProjection {
    UUID getId();
    String getName();
    String getDescription();
    BigDecimal getPrice();
    Integer getIn_stock();
    Boolean getFeatured();
    Boolean getPromotion();
    FileProjection getThumbnail();
}
