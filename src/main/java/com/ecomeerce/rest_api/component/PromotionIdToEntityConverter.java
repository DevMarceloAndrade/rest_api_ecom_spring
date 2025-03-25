package com.ecomeerce.rest_api.component;

import com.ecomeerce.rest_api.models.Promotion;
import com.ecomeerce.rest_api.services.PromotionService;
import org.springframework.stereotype.Component;

@Component
public class PromotionIdToEntityConverter extends DataConverterById<Promotion>{

    public PromotionIdToEntityConverter(PromotionService baseService) {
        super(baseService);
    }
}
