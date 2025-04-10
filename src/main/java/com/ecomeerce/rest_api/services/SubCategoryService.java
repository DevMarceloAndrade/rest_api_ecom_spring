package com.ecomeerce.rest_api.services;

import com.ecomeerce.rest_api.models.SubCategory;
import com.ecomeerce.rest_api.repositories.SubCategoryRepository;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubCategoryService extends BaseService <SubCategory>{

    @Autowired
    public SubCategoryService(SubCategoryRepository dataBaseRepository, Validator validator) {
        super(dataBaseRepository, validator);
    }
}
