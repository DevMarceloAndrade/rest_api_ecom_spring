package com.ecomeerce.rest_api.controllers;

import com.ecomeerce.rest_api.models.ProductPromotion;
import com.ecomeerce.rest_api.projection.ProductPromotionProjection;
import com.ecomeerce.rest_api.services.ProductPromotionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/product-promotion")
public class ProductPromotionController extends BaseController<ProductPromotion>{
    private final ProductPromotionService productPromotionService;

    public ProductPromotionController(ProductPromotionService baseService) {
        super(baseService);
        this.productPromotionService = baseService;
    }

    @GetMapping("/promotion/{id}")
    public ResponseEntity<List<ProductPromotionProjection>> readProductPromotionByPromotionId(@PathVariable("id")UUID id){
         return ResponseEntity.status(HttpStatus.OK).body(productPromotionService.readByPromotionId(id));
    }
}
