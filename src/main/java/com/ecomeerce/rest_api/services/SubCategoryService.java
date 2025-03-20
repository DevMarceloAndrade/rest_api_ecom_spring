package com.ecomeerce.rest_api.services;

import com.ecomeerce.rest_api.models.SubCategory;
import com.ecomeerce.rest_api.repositories.SubCategoryRepository;
import jakarta.validation.Validator;
import org.springframework.stereotype.Service;

@Service
public class SubCategoryService extends BaseService <SubCategory>{

    public SubCategoryService(SubCategoryRepository dataBaseRepository, Validator validator) {
        super(dataBaseRepository, validator);
    }
}
