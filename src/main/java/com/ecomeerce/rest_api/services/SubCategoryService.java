package com.ecomeerce.rest_api.services;

import com.ecomeerce.rest_api.models.SubCategory;
import com.ecomeerce.rest_api.repositories.SubCategoryRepository;
import jakarta.validation.Validator;

public class SubCategoryService extends BaseService <SubCategory>{

    public SubCategoryService(SubCategoryRepository dataBaseRepository, Validator validator) {
        super(dataBaseRepository, validator);
    }
}
