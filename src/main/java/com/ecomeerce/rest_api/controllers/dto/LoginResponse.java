package com.ecomeerce.rest_api.controllers.dto;

public record LoginResponse(String accessToken, Long expiresIn) {
}
