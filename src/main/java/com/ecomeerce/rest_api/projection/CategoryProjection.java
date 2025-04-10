package com.ecomeerce.rest_api.projection;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
import java.util.UUID;

@JsonPropertyOrder({"id", "name", "position", "subCategories"})
public interface CategoryProjection {
    UUID getId();
    String getName();
    Integer getPosition();
    List<SubCategoryProjection> getSubCategories();
}
