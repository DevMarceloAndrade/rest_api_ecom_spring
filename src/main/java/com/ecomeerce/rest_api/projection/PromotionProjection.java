package com.ecomeerce.rest_api.projection;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.UUID;

@JsonPropertyOrder({"id", "name", "description", "featured", "thumbnail"})
public interface PromotionProjection {
    UUID getId();
    String getName();
    String getDescription();
    Boolean getFeatured();
    FileProjection getThumbnail();
}
