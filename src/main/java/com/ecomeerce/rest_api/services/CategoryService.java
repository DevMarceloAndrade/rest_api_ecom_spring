package com.ecomeerce.rest_api.services;

import com.ecomeerce.rest_api.exception.EntityDoesNotExist;
import com.ecomeerce.rest_api.models.Category;
import com.ecomeerce.rest_api.projection.CategoryProjection;
import com.ecomeerce.rest_api.repositories.CategoryRepository;
import jakarta.validation.Validator;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CategoryService extends BaseService<Category>{
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository dataBaseRepository, Validator validator) {
        super(dataBaseRepository, validator);
        this.categoryRepository = dataBaseRepository;
    }

    public CategoryProjection findByIdIncludingSubCategories(UUID id){
        return categoryRepository.findByIdIncludingSubCategories(id)
                .orElseThrow(EntityDoesNotExist::new);
    }
}
