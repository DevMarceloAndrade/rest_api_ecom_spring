package com.ecomeerce.rest_api.projection;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.UUID;

@JsonPropertyOrder({"id", "name"})
public interface SubCategoryProjection {
    UUID getId();
    String getName();
}
