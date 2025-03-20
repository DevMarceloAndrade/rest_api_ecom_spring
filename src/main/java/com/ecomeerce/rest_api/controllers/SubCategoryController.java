package com.ecomeerce.rest_api.controllers;

import com.ecomeerce.rest_api.models.SubCategory;
import com.ecomeerce.rest_api.services.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subCategory")
public class SubCategoryController extends BaseController<SubCategory>{

    @Autowired
    public SubCategoryController(SubCategoryService baseService) {
        super(baseService);
    }

}
