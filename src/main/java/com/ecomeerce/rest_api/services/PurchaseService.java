package com.ecomeerce.rest_api.services;

import com.ecomeerce.rest_api.models.Purchase;
import com.ecomeerce.rest_api.repositories.PurchaseRepository;
import jakarta.validation.Validator;

public class PurchaseService extends BaseService<Purchase>{
    public PurchaseService(PurchaseRepository dataBaseRepository, Validator validator) {
        super(dataBaseRepository, validator);
    }
}
