package com.ecomeerce.rest_api.services;

import com.ecomeerce.rest_api.models.Category;
import com.ecomeerce.rest_api.repositories.CategoryRepository;
import jakarta.validation.Validator;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends BaseService<Category>{
    public CategoryService(CategoryRepository dataBaseRepository, Validator validator) {
        super(dataBaseRepository, validator);
    }
}
