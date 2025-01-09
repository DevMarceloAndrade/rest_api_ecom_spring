package com.ecomeerce.rest_api.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@ConfigurationProperties(prefix = "file")
public class FileStorageConfig {

    private String uploadDir;

}
