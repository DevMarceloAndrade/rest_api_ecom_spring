package com.ecomeerce.rest_api.controllers;

import com.ecomeerce.rest_api.models.Category;
import com.ecomeerce.rest_api.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<Category> createCategory(@RequestBody Category jsonData){
        Category newCategory = categoryService.create(jsonData);

        return ResponseEntity.status(HttpStatus.OK).body(newCategory);
    }
}
