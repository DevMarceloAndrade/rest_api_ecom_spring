package com.ecomeerce.rest_api.controllers;

import com.ecomeerce.rest_api.services.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class BaseController<T> {

    public BaseService<T> baseService;

    public BaseController(BaseService<T> baseService) {
        this.baseService = baseService;
    }

    @PostMapping("/")
    public ResponseEntity<T> createEntity(@RequestBody T jsonData){
        T newEntity = baseService.create(jsonData);

        return ResponseEntity.status(HttpStatus.OK).body(newEntity);
    }
}
