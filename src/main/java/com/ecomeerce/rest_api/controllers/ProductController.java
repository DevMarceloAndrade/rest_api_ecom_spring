package com.ecomeerce.rest_api.controllers;

import com.ecomeerce.rest_api.models.Category;
import com.ecomeerce.rest_api.models.Product;
import com.ecomeerce.rest_api.models.SubCategory;
import com.ecomeerce.rest_api.services.FileService;
import com.ecomeerce.rest_api.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private FileService fileService;

    @PostMapping
    public ResponseEntity<Product> createProduct(
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestParam(value = "multipleFiles", required = false) MultipartFile[] multipleFiles,
            @RequestBody Product jsonData
    ){
        Product newProduct = productService.create(jsonData);

        if(file != null){
            newProduct.setThumbnail(fileService.fileStorage(file,"promotion",jsonData.getName()));
        }
        if(multipleFiles != null){
            SubCategory subCategory = newProduct.getSub_category();
            Category category = subCategory.getCategory();

            fileService.createAll(multipleFiles,newProduct,"produtos", category.getName(),subCategory.getName());
        }
        return  ResponseEntity.status(HttpStatus.OK).body(newProduct);

    }
}
