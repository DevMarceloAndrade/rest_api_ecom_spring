package com.ecomeerce.rest_api.component;

import com.ecomeerce.rest_api.models.Purchase;
import com.ecomeerce.rest_api.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;

public class PurchaseIdToEntityConverter extends DataConverterById<Purchase>{
    @Autowired
    public PurchaseIdToEntityConverter(PurchaseService baseService) {
        super(baseService);
    }
}
