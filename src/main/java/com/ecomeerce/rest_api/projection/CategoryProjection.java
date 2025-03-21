package com.ecomeerce.rest_api.projection;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
import java.util.UUID;

@JsonPropertyOrder({"id", "name", "position", "sub_categories"})
public interface CategoryProjection {
    UUID getId();
    String getName();
    Integer getPosition();
    List<SubCategoryProjection> getSub_categories();
}
