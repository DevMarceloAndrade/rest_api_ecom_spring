package com.ecomeerce.rest_api.services;

import com.ecomeerce.rest_api.exception.EntityDoesNotExist;
import com.ecomeerce.rest_api.models.Category;
import com.ecomeerce.rest_api.projection.CategoryProjection;
import com.ecomeerce.rest_api.repositories.CategoryRepository;
import jakarta.validation.Validator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService extends BaseService<Category>{
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository dataBaseRepository, Validator validator) {
        super(dataBaseRepository, validator);
        this.categoryRepository = dataBaseRepository;
    }

    public CategoryProjection findByIdStandardType(UUID id){
        return categoryRepository.findByIdStandardType(id)
                .orElseThrow(EntityDoesNotExist::new);
    }

    public List<CategoryProjection> findAllStandardType(){
        return categoryRepository.findAllStandardType()
                .orElseThrow(EntityDoesNotExist::new);
    }

}
