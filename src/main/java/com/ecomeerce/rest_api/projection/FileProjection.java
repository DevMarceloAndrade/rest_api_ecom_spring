package com.ecomeerce.rest_api.projection;


import java.util.UUID;

public interface FileProjection {
    UUID getId();
    String getFile_name();
    String getFile_downloadUri();
    String geFile_targetLocation();
    String getFile_type();
    Long getFile_size();
}
