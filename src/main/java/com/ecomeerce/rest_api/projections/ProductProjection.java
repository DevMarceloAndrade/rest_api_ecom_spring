package com.ecomeerce.rest_api.projections;



import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.math.BigDecimal;
import java.util.UUID;

@JsonPropertyOrder({"id", "name", "description", "price", "inStock", "featured", "promotion", "thumbnail"})
public interface ProductProjection {
    UUID getId();
    SubCategoryProjection getSubCategory();
    String getName();
    String getDescription();
    BigDecimal getPrice();
    Integer getInStock();
    Boolean getFeatured();
    Boolean getPromotion();
    FileProjection getThumbnail();
}
