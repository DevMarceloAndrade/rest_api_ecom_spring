package com.ecomeerce.rest_api.component;

import com.ecomeerce.rest_api.models.Product;
import com.ecomeerce.rest_api.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductIdToEntityConverter extends  DataConverterById<Product>{

    @Autowired
    public ProductIdToEntityConverter(ProductService baseService) {
        super(baseService);
    }
}
