package com.ecomeerce.rest_api.controllers;

import com.ecomeerce.rest_api.models.Category;
import com.ecomeerce.rest_api.models.Product;
import com.ecomeerce.rest_api.models.SubCategory;
import com.ecomeerce.rest_api.projection.ProductProjection;
import com.ecomeerce.rest_api.services.FileService;
import com.ecomeerce.rest_api.services.ProductService;
import com.ecomeerce.rest_api.services.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/product")
public class ProductController extends BaseController<Product>{

    private final ProductService productService;
    private final FileService fileService;
    private final SubCategoryService subCategoryService;

    @Autowired
    public ProductController(ProductService baseService, FileService fileService, SubCategoryService subCategoryService) {
        super(baseService);
        this.productService = baseService;
        this.fileService = fileService;
        this.subCategoryService = subCategoryService;
    }

    @PostMapping("/file/")
    public ResponseEntity<Product> createProduct(
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestParam(value = "multipleFiles", required = false) MultipartFile[] multipleFiles,
            @RequestBody Product jsonData
    ) {
        Product newProduct = productService.create(jsonData);

        if (file != null) {
            SubCategory subCategory = newProduct.getSub_category();
            Category category = subCategory.getCategory();

            newProduct.setThumbnail(fileService.fileStorage(file, "produtos", category.getName(), subCategory.getName()));
        }
        if (multipleFiles != null) {
            SubCategory subCategory = newProduct.getSub_category();
            Category category = subCategory.getCategory();

            fileService.createAll(multipleFiles, newProduct, "produtos", category.getName(), subCategory.getName());
        }
        return ResponseEntity.status(HttpStatus.OK).body(newProduct);

    }

    @GetMapping("/sub-category/{id}")
    public ResponseEntity<List<ProductProjection>> readAllBySubCategoryId(@PathVariable("id") UUID id){
        SubCategory  subCategory = subCategoryService.readById(id);
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAllBySubCategory(subCategory));
    }
}
