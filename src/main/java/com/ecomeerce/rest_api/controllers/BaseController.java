package com.ecomeerce.rest_api.controllers;

import com.ecomeerce.rest_api.services.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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

    @GetMapping("/{id}")
    public ResponseEntity<T> readEntity(@PathVariable("id") UUID id){
        T searchEntity = baseService.readById(id);

        return ResponseEntity.status(HttpStatus.OK).body(searchEntity);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEntity(@PathVariable("id") UUID id){
        baseService.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Entidade deletada.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> updateEntity(@PathVariable("id") UUID id, @RequestBody T jsonData){
        T updateEntity = baseService.updateById(id,jsonData);

        return ResponseEntity.status(HttpStatus.OK).body(updateEntity);
    }

}
