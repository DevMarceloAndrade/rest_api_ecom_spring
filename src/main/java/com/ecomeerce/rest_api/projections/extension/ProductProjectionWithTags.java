package com.ecomeerce.rest_api.projections.extension;

import com.ecomeerce.rest_api.models.Tag;
import com.ecomeerce.rest_api.projections.ProductProjection;

import java.util.List;

public interface ProductProjectionWithTags extends ProductProjection {

    List<Tag> getTags();
}
