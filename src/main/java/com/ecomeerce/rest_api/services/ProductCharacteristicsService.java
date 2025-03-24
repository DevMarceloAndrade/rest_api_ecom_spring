package com.ecomeerce.rest_api.services;

import com.ecomeerce.rest_api.models.ProductCharacteristics;
import com.ecomeerce.rest_api.repositories.ProductCharacteristicsRepository;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCharacteristicsService extends BaseService<ProductCharacteristics>{

    private final ProductCharacteristicsRepository productCharacteristicsRepository;

    @Autowired
    public ProductCharacteristicsService(ProductCharacteristicsRepository dataBaseRepository, Validator validator) {
        super(dataBaseRepository, validator);
        this.productCharacteristicsRepository = dataBaseRepository;
    }
}
