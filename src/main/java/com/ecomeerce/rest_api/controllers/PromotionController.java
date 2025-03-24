package com.ecomeerce.rest_api.controllers;

import com.ecomeerce.rest_api.models.Promotion;
import com.ecomeerce.rest_api.projection.PromotionProjection;
import com.ecomeerce.rest_api.services.FileService;
import com.ecomeerce.rest_api.services.PromotionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/promotion")
@Tag(name = "promotion", description = "Controlador para manipulação de dados das promoções")
public class PromotionController {

    @Autowired
    private PromotionService promotionService;

    @Autowired
    private FileService fileService;

    @PostMapping("/create")
    @Operation(summary = "Salva dados da promoção", description = "Método para salvar dados de uma promoção, incluindo ou não uma thumbnail.")
    @ApiResponse(responseCode = "201", description = "Promoção cadastrada.")
    @ApiResponse(responseCode = "500", description = "Erro no servidor.")
    public ResponseEntity<Promotion> createPromotion(
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestBody Promotion jsonData
    ){
        if(file!=null){
            jsonData.setThumbnail(fileService.fileStorage(file,"promotion",jsonData.getName()));
        }

        return ResponseEntity.status(HttpStatus.OK).body(promotionService.create(jsonData));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtem promoção via ID", description = "Método para obter os dados de uma promoção.")
    @ApiResponse(responseCode = "201")
    @ApiResponse(responseCode = "500", description = "Erro no servidor.")
    public ResponseEntity<PromotionProjection> readPromotionById(@PathVariable("id") UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(promotionService.findByIdStandardType(id));
    }

    @GetMapping("/")
    @Operation(summary = "Obtem promoção via ID", description = "Método para obter os dados de uma promoção.")
    @ApiResponse(responseCode = "201")
    @ApiResponse(responseCode = "500", description = "Erro no servidor.")
    public ResponseEntity<List<PromotionProjection>> readAllPromotion(){
        return ResponseEntity.status(HttpStatus.OK).body(promotionService.findAllStandardType());
    }

    @PostMapping("/{id}/upload/thumbnail")
    @Operation(summary = "Salva thumbnail de uma promoção", description = "Método para salvar apenas a thumbanail de uma promoção.")
    @ApiResponse(responseCode = "201", description = "Thumbanail cadastrada.")
    @ApiResponse(responseCode = "500", description = "Erro no servidor.")
    public ResponseEntity<Promotion> uploadPromotionThumbnail(@PathVariable("id") UUID id, @RequestParam("file") MultipartFile file){
        promotionService.checkEntityById(id);
        Promotion promotion = promotionService.readById(id);

        if(promotion.getThumbnail()!=null){
            fileService.delete(promotion.getThumbnail().getId());
        }

        promotion.setThumbnail(fileService.fileStorage(file,"promotion",file.getName()));
        promotionService.updateById(id,promotion);

        return ResponseEntity.status(HttpStatus.OK).body(promotion);
    }
    @Operation(summary = "Deleta uma promoção", description = "Método para deletar uma promoção via ID.")
    @ApiResponse(responseCode = "201", description = "Promoção Deletada.")
    @ApiResponse(responseCode = "500", description = "Erro no servidor.")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePromotion(@PathVariable("id") UUID id){
        promotionService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Promoção deletada.");
    }

}
