package com.ecomeerce.rest_api.controllers;

import com.ecomeerce.rest_api.models.Category;
import com.ecomeerce.rest_api.projection.CategoryProjection;
import com.ecomeerce.rest_api.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/category")
public class CategoryController extends BaseController<Category> {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService baseService) {
        super(baseService);
        this.categoryService = baseService;
    }

    @GetMapping("/sub-categories/{id}")
    public ResponseEntity<CategoryProjection> getCategoryByIdStandardType(@PathVariable("id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.findByIdStandardType(id));
    }

    @GetMapping("/sub-categories/")
    public ResponseEntity<List<CategoryProjection>> getAllCategoryStandardType() {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.findAllStandardType());
    }
}
