package com.ecomeerce.rest_api.services;

import com.ecomeerce.rest_api.models.Purchase;
import com.ecomeerce.rest_api.repositories.PurchaseRepository;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;

public class PurchaseService extends BaseService<Purchase>{
    @Autowired
    public PurchaseService(PurchaseRepository dataBaseRepository, Validator validator) {
        super(dataBaseRepository, validator);
    }
}
