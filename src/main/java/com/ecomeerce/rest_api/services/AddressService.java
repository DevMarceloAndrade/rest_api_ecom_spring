package com.ecomeerce.rest_api.services;

import com.ecomeerce.rest_api.models.Address;
import com.ecomeerce.rest_api.repositories.AddressRepository;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends BaseService<Address>{
    @Autowired
    public AddressService(AddressRepository dataBaseRepository, Validator validator) {
        super(dataBaseRepository, validator);
    }
}
