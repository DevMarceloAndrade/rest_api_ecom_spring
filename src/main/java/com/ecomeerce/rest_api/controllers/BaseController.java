package com.ecomeerce.rest_api.controllers;

import com.ecomeerce.rest_api.services.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/")
    public ResponseEntity<Page<T>> readAllEntity(
            @RequestParam(value = "orderBy", required = false, defaultValue = "createdAt") String orderBy,
            @RequestParam(value = "orderType", required = false, defaultValue = "ASC") Sort.Direction orderType,
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "perPage", required = false, defaultValue = "10") Integer perPage
    ){
        Pageable pageable = PageRequest.of(page-1,perPage,Sort.by(orderType,orderBy));
        Page<T> searchEntity = baseService.readAll(pageable);

        return ResponseEntity.status(HttpStatus.OK).body(searchEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEntity(@PathVariable("id") UUID id){
        baseService.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Entidade deletada.");
    }

    @DeleteMapping("/")
    public ResponseEntity<String> deleteMultipleEntity(@RequestBody List<UUID> ids){
        baseService.deleteMultipleById(ids);

        return ResponseEntity.status(HttpStatus.OK).body("Entidades deletadas");
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> updateEntity(@PathVariable("id") UUID id, @RequestBody T jsonData){
        T updateEntity = baseService.updateById(id,jsonData);

        return ResponseEntity.status(HttpStatus.OK).body(updateEntity);
    }
}
