package com.ecomeerce.rest_api.controllers;

import com.ecomeerce.rest_api.models.Promotion;
import com.ecomeerce.rest_api.services.FileService;
import com.ecomeerce.rest_api.services.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PromotionController {

    @Autowired
    private PromotionService promotionService;

    @Autowired
    private FileService fileService;

    @PostMapping("/api/promotion/create")
    public Promotion createPromotion(@RequestBody Promotion jsonData ){

        return promotionService.create(jsonData);

    }

}
