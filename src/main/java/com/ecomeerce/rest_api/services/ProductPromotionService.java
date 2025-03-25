package com.ecomeerce.rest_api.services;

import com.ecomeerce.rest_api.models.ProductPromotion;
import com.ecomeerce.rest_api.repositories.ProductPromotionRepository;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductPromotionService extends BaseService<ProductPromotion> {
    private final ProductPromotionRepository productPromotionRepository;

    @Autowired
    public ProductPromotionService(ProductPromotionRepository dataBaseRepository, Validator validator) {
        super(dataBaseRepository, validator);
        this.productPromotionRepository = dataBaseRepository;
    }
}
