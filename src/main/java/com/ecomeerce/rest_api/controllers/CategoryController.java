package com.ecomeerce.rest_api.controllers;

import com.ecomeerce.rest_api.models.Category;
import com.ecomeerce.rest_api.projections.CategoryProjection;
import com.ecomeerce.rest_api.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Page<CategoryProjection>> getAllCategoryStandardType(
            @RequestParam(value = "orderBy", required = false, defaultValue = "createdAt") String orderBy,
            @RequestParam(value = "orderType", required = false, defaultValue = "ASC") Sort.Direction orderType,
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "perPage", required = false, defaultValue = "10") Integer perPage
    ) {
        Pageable pageable = PageRequest.of(page-1,perPage,Sort.by(orderType,orderBy));

        return ResponseEntity.status(HttpStatus.OK).body(categoryService.findAllStandardType(pageable));
    }
}
