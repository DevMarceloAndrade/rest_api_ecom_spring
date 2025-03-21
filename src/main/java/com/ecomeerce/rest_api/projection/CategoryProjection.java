package com.ecomeerce.rest_api.projection;

import java.util.List;
import java.util.UUID;

public interface CategoryProjection {
    UUID getId();
    String getName();
    Integer getPosition();
    List<SubCategoryProjection> getSub_categories();
}
