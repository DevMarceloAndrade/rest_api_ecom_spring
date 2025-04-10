package com.ecomeerce.rest_api.services;

import com.ecomeerce.rest_api.models.ProductPurchased;
import com.ecomeerce.rest_api.repositories.ProductPurchasedRepository;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductPurchasedService extends BaseService<ProductPurchased>{
    @Autowired
    public ProductPurchasedService(ProductPurchasedRepository dataBaseRepository, Validator validator) {
        super(dataBaseRepository, validator);
    }
}
