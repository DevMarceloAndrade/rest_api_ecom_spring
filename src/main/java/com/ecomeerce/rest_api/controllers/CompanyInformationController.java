package com.ecomeerce.rest_api.controllers;

import com.ecomeerce.rest_api.models.CompanyInformation;
import com.ecomeerce.rest_api.services.CompanyInformationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/companyInformation")
public class CompanyInformationController extends BaseController<CompanyInformation>{
    public CompanyInformationController(CompanyInformationService baseService) {
        super(baseService);
    }
}
