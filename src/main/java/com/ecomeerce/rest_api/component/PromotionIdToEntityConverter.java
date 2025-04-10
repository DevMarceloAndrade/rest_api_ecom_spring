package com.ecomeerce.rest_api.component;

import com.ecomeerce.rest_api.models.Promotion;
import com.ecomeerce.rest_api.services.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PromotionIdToEntityConverter extends DataConverterById<Promotion>{

    @Autowired
    public PromotionIdToEntityConverter(PromotionService baseService) {
        super(baseService);
    }
}
