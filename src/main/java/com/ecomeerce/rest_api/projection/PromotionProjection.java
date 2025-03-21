package com.ecomeerce.rest_api.projection;

import java.util.UUID;

public interface PromotionProjection {
    UUID getId();
    String getName();
    String getDescription();
    Boolean getFeatured();
    FileProjection getThumbnail();
}
