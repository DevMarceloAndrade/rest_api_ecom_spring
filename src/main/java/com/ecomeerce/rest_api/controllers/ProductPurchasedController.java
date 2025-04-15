package com.ecomeerce.rest_api.controllers;

import com.ecomeerce.rest_api.models.ProductPurchased;
import com.ecomeerce.rest_api.services.ProductPurchasedService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/productPurchased")
public class ProductPurchasedController extends BaseController<ProductPurchased>{
    public ProductPurchasedController(ProductPurchasedService baseService) {
        super(baseService);
    }
}
