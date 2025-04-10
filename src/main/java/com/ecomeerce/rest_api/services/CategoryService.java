package com.ecomeerce.rest_api.services;

import com.ecomeerce.rest_api.exception.EntityDoesNotExist;
import com.ecomeerce.rest_api.models.Category;
import com.ecomeerce.rest_api.projection.CategoryProjection;
import com.ecomeerce.rest_api.repositories.CategoryRepository;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class CategoryService extends BaseService<Category>{
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository dataBaseRepository, Validator validator) {
        super(dataBaseRepository, validator);
        this.categoryRepository = dataBaseRepository;
    }

    public CategoryProjection findByIdStandardType(UUID id){
        return categoryRepository.findByIdStandardType(id)
                .orElseThrow(EntityDoesNotExist::new);
    }

    public Page<CategoryProjection> findAllStandardType(Pageable pageable){
        return categoryRepository.findAllStandardType(pageable)
                .orElseThrow(EntityDoesNotExist::new);
    }

}
