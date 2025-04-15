package com.ecomeerce.rest_api.services;

import com.ecomeerce.rest_api.models.Tag;
import com.ecomeerce.rest_api.repositories.TagRepository;
import jakarta.validation.Validator;

public class TagService extends BaseService<Tag>{
    public TagService(TagRepository dataBaseRepository, Validator validator) {
        super(dataBaseRepository, validator);
    }
}
