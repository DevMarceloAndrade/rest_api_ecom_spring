package com.ecomeerce.rest_api.controllers;

import com.ecomeerce.rest_api.models.Address;
import com.ecomeerce.rest_api.services.AddressService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/address")
public class AddressController extends BaseController<Address>{
    public AddressController(AddressService baseService) {
        super(baseService);
    }
}
