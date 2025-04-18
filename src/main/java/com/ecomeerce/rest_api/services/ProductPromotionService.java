package com.ecomeerce.rest_api.services;

import com.ecomeerce.rest_api.exception.EntityDoesNotExist;
import com.ecomeerce.rest_api.models.ProductPromotion;
import com.ecomeerce.rest_api.projections.ProductPromotionProjection;
import com.ecomeerce.rest_api.repositories.ProductPromotionRepository;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class ProductPromotionService extends BaseService<ProductPromotion> {
    private final ProductPromotionRepository productPromotionRepository;

    @Autowired
    public ProductPromotionService(ProductPromotionRepository dataBaseRepository, Validator validator) {
        super(dataBaseRepository, validator);
        this.productPromotionRepository = dataBaseRepository;
    }

    public Page<ProductPromotionProjection> readByPromotionId(UUID id, Pageable pageable){

        return productPromotionRepository.getByPromotionId(id,pageable)
                .orElseThrow(EntityDoesNotExist::new);
    }
}
