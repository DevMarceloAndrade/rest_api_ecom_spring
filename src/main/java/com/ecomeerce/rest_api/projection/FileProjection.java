package com.ecomeerce.rest_api.projection;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.UUID;

@JsonPropertyOrder({"id", "file_name", "file_downloadUri", "file_targetLocation", "file_type", "file_size"})
public interface FileProjection {
    UUID getId();
    String getFile_name();
    String getFile_downloadUri();
    String geFile_targetLocation();
    String getFile_type();
    Long getFile_size();
}
