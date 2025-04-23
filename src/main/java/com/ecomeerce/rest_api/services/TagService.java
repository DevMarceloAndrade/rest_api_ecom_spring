package com.ecomeerce.rest_api.services;

import com.ecomeerce.rest_api.models.Tag;
import com.ecomeerce.rest_api.repositories.TagRepository;
import jakarta.validation.Validator;
import org.springframework.stereotype.Service;

@Service
public class TagService extends BaseService<Tag>{
    public TagService(TagRepository dataBaseRepository, Validator validator) {
        super(dataBaseRepository, validator);
    }
}
