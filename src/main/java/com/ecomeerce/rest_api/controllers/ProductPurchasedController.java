package com.ecomeerce.rest_api.controllers;

import com.ecomeerce.rest_api.models.ProductPurchased;
import com.ecomeerce.rest_api.services.ProductPurchasedService;

public class ProductPurchasedController extends BaseController<ProductPurchased>{
    public ProductPurchasedController(ProductPurchasedService baseService) {
        super(baseService);
    }
}
