package com.ecomeerce.rest_api.projection;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.UUID;

@JsonPropertyOrder({"id", "name", "downloadUri", "targetLocation", "type", "size"})
public interface FileProjection {
    UUID getId();
    String getName();
    String getDownloadUri();
    String getTargetLocation();
    String getType();
    Long getSize();
}
