package com.ecomeerce.rest_api.services;

import com.ecomeerce.rest_api.models.TagType;
import com.ecomeerce.rest_api.repositories.TagTypeRepository;
import jakarta.validation.Validator;

public class TagTypeService extends BaseService<TagType>{
    public TagTypeService(TagTypeRepository dataBaseRepository, Validator validator) {
        super(dataBaseRepository, validator);
    }
}
