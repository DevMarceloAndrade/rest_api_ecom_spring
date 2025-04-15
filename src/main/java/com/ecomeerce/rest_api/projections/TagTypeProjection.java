package com.ecomeerce.rest_api.projections;

import java.util.List;
import java.util.UUID;

public interface TagTypeProjection {
    UUID getId();
    String getName();
    List<TagsProjection> getTags();
}
