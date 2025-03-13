package com.ecomeerce.rest_api.services;

import com.ecomeerce.rest_api.models.File;
import com.ecomeerce.rest_api.models.Promotion;
import com.ecomeerce.rest_api.repositories.PromotionRepository;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromotionService extends BaseService<Promotion>{

    @Autowired
    public PromotionService(PromotionRepository dataBaseRepository, Validator validator) {
        super(dataBaseRepository, validator);
    }
}
