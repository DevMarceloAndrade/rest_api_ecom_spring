package com.ecomeerce.rest_api.services;

import com.ecomeerce.rest_api.exception.EntityDoesNotExist;
import com.ecomeerce.rest_api.models.Promotion;
import com.ecomeerce.rest_api.projection.CategoryProjection;
import com.ecomeerce.rest_api.projection.PromotionProjection;
import com.ecomeerce.rest_api.repositories.PromotionRepository;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class PromotionService extends BaseService<Promotion>{

    private final PromotionRepository promotionRepository;

    @Autowired
    public PromotionService(PromotionRepository dataBaseRepository, Validator validator) {
        super(dataBaseRepository, validator);
        this.promotionRepository = dataBaseRepository;
    }

    public PromotionProjection findByIdStandardType(UUID id){
        return promotionRepository.findByIdStandardType(id)
                .orElseThrow(EntityDoesNotExist::new);

    }

    public Page<PromotionProjection> findAllStandardType(Pageable pageable){
        return promotionRepository.findAllStandardType(pageable)
                .orElseThrow(EntityDoesNotExist::new);
    }
}
