package com.ecomeerce.rest_api.controllers;

import com.ecomeerce.rest_api.models.Purchase;
import com.ecomeerce.rest_api.services.PurchaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseController extends BaseController<Purchase>{
    public PurchaseController(PurchaseService baseService) {
        super(baseService);
    }
}
