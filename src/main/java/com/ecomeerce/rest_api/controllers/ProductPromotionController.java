package com.ecomeerce.rest_api.controllers;

import com.ecomeerce.rest_api.models.ProductPromotion;
import com.ecomeerce.rest_api.services.ProductPromotionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product-promotion")
public class ProductPromotionController extends BaseController<ProductPromotion>{
    private final ProductPromotionService productPromotionService;

    public ProductPromotionController(ProductPromotionService baseService) {
        super(baseService);
        this.productPromotionService = baseService;
    }
}
