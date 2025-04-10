package com.ecomeerce.rest_api.services;

import com.ecomeerce.rest_api.models.CompanyInformation;
import com.ecomeerce.rest_api.repositories.CompanyInformationRepository;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyInformationService extends BaseService<CompanyInformation>{
    @Autowired
    public CompanyInformationService(CompanyInformationRepository dataBaseRepository, Validator validator) {
        super(dataBaseRepository, validator);
    }
}
