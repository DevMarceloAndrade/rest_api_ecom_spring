package com.ecomeerce.rest_api.controllers;

import com.ecomeerce.rest_api.models.File;
import com.ecomeerce.rest_api.models.Promotion;
import com.ecomeerce.rest_api.services.FileService;
import com.ecomeerce.rest_api.services.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.UUID;

@RestController
@RequestMapping("/api/promotion")
public class PromotionController {

    @Autowired
    private PromotionService promotionService;

    @Autowired
    private FileService fileService;

    @PostMapping("/create")
    public Promotion createPromotion(
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestBody Promotion jsonData
    ){
        if(file!=null){
            File newThumbnail = fileService.create(file,"promotion",jsonData.getName());
            jsonData.setThumbnail(newThumbnail);
        }

        return promotionService.create(jsonData);
    }

    @PostMapping("/{id}/upload/thumbnail")
    public Promotion uploadPromotionThumbnail(@PathVariable("id") UUID id, @RequestParam("file") MultipartFile file){
        promotionService.checkEntityById(id);
        Promotion promotion = promotionService.readById(id);

        if(promotion.getThumbnail()!=null){
            fileService.delete(promotion.getThumbnail().getId());
        }

        File fileUploaded = fileService.create(file,"promotion", promotion.getName());

        promotion.setThumbnail(fileUploaded);
        promotionService.updateById(id,promotion);
        return promotion;
    }

}
