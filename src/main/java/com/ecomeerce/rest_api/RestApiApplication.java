package com.ecomeerce.rest_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import pro.handler.file.config.FileStorageConfig;


@EnableConfigurationProperties({
		FileStorageConfig.class
})
@SpringBootApplication
@ComponentScan(basePackages = {"com.ecomeerce.rest_api", "pro.handler.file"})
public class RestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}
}
