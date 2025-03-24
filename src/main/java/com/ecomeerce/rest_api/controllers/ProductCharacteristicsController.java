package com.ecomeerce.rest_api.controllers;

import com.ecomeerce.rest_api.models.ProductCharacteristics;
import com.ecomeerce.rest_api.services.ProductCharacteristicsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product-characteristics")
public class ProductCharacteristicsController extends BaseController<ProductCharacteristics>{

    private final ProductCharacteristicsService productCharacteristicsService;

    public ProductCharacteristicsController(ProductCharacteristicsService baseService) {
        super(baseService);
        this.productCharacteristicsService = baseService;
    }
}
