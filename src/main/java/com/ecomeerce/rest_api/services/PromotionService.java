package com.ecomeerce.rest_api.services;

import com.ecomeerce.rest_api.exception.EntityDoesNotExist;
import com.ecomeerce.rest_api.models.Promotion;
import com.ecomeerce.rest_api.projection.PromotionProjection;
import com.ecomeerce.rest_api.repositories.PromotionRepository;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PromotionService extends BaseService<Promotion>{

    private PromotionRepository promotionRepository;

    @Autowired
    public PromotionService(PromotionRepository dataBaseRepository, Validator validator) {
        super(dataBaseRepository, validator);
        this.promotionRepository = dataBaseRepository;
    }

    public PromotionProjection getCompletePromotion(UUID id){
        return promotionRepository.findByIdWithRelations(id)
                .orElseThrow(EntityDoesNotExist::new);

    }
}
