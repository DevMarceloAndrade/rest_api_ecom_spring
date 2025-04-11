package com.ecomeerce.rest_api.projections;

import java.util.UUID;

public interface ReviewProjection {
    UUID getId();
    String getTitle();
    String getText();
    Integer getRating();
}
