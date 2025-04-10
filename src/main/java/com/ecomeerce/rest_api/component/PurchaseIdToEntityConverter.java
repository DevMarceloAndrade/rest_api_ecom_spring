package com.ecomeerce.rest_api.component;

import com.ecomeerce.rest_api.models.Purchase;
import com.ecomeerce.rest_api.services.PurchaseService;

public class PurchaseIdToEntityConverter extends DataConverterById<Purchase>{
    public PurchaseIdToEntityConverter(PurchaseService baseService) {
        super(baseService);
    }
}
