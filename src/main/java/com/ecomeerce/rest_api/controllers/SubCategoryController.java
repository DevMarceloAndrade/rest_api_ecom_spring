package com.ecomeerce.rest_api.controllers;

import com.ecomeerce.rest_api.models.SubCategory;
import com.ecomeerce.rest_api.services.SubCategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subCategory")
public class SubCategoryController extends BaseController<SubCategory>{
    public SubCategoryController(SubCategoryService baseService) {
        super(baseService);
    }
}
