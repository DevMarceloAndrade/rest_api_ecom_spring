package com.ecomeerce.rest_api.services;

import com.ecomeerce.rest_api.exception.EntityDoesNotExist;
import com.ecomeerce.rest_api.models.Product;
import com.ecomeerce.rest_api.projections.ProductProjection;
import com.ecomeerce.rest_api.projections.extension.ProductProjectionWithTags;
import com.ecomeerce.rest_api.repositories.ProductRepository;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService extends BaseService<Product>{

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository dataBaseRepository, Validator validator) {
        super(dataBaseRepository, validator);
        this.productRepository = dataBaseRepository;
    }

    public ProductProjection findByIdStandardType(UUID id){
        return productRepository.findByIdStandardType(id)
                .orElseThrow(EntityDoesNotExist::new);
    }

    public Page<ProductProjection> findAllBySubCategory(UUID id, Pageable pageable){
        return productRepository.findAllBySubCategory(id, pageable)
                .orElseThrow(EntityDoesNotExist::new);
    }

    public Page<ProductProjectionWithTags> findAllByTags(List<UUID> ids, Pageable pageable){
        String idsIn = ids.stream()
                .map(UUID::toString)
                .collect(Collectors.joining(","));

        return productRepository.findAllByTags(idsIn , ids.size(), pageable)
                .orElseThrow(EntityDoesNotExist::new);
    }

    public Product findByProductPromotionId(UUID id){
       return productRepository.findByProductPromotionId(id)
                .orElseThrow(EntityDoesNotExist::new);
    }
}
