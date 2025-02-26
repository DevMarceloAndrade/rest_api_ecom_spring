package com.ecomeerce.rest_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityDoesNotExist extends RuntimeException {
    public EntityDoesNotExist() {
        super("Entity does not Exist");
    }
}
