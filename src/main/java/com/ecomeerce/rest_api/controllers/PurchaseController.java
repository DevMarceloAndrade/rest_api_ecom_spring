package com.ecomeerce.rest_api.controllers;

import com.ecomeerce.rest_api.models.Purchase;
import com.ecomeerce.rest_api.services.PurchaseService;

public class PurchaseController extends BaseController<Purchase>{
    public PurchaseController(PurchaseService baseService) {
        super(baseService);
    }
}
