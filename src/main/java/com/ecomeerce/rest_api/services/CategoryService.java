package com.ecomeerce.rest_api.services;

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

    public CategoryProjection findByIdWithRelations(UUID id){
        return categoryRepository.findByIdWithRelations(id);
    }
}
