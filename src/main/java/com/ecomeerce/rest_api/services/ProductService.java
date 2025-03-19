package com.ecomeerce.rest_api.services;

import com.ecomeerce.rest_api.models.Product;
import com.ecomeerce.rest_api.repositories.ProductRepository;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends BaseService<Product>{

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository dataBaseRepository, Validator validator) {
        super(dataBaseRepository, validator);
        this.productRepository = dataBaseRepository;
    }


}
