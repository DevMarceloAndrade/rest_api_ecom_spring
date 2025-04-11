package com.ecomeerce.rest_api.controllers;

import com.ecomeerce.rest_api.models.ProductPromotion;
import com.ecomeerce.rest_api.projections.ProductPromotionProjection;
import com.ecomeerce.rest_api.services.ProductPromotionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<Page<ProductPromotionProjection>> readProductsPromotionByPromotionId(
            @PathVariable("id")UUID id,
            @RequestParam(value = "orderBy", required = false, defaultValue = "createdAt") String orderBy,
            @RequestParam(value = "orderType", required = false, defaultValue = "ASC") Sort.Direction orderType,
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "perPage", required = false, defaultValue = "10") Integer perPage
    ){
        Pageable pageable = PageRequest.of(page-1,perPage,Sort.by(orderType,orderBy));

        return ResponseEntity.status(HttpStatus.OK).body(productPromotionService.readByPromotionId(id,pageable));
    }
}
