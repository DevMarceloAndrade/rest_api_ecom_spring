package com.ecomeerce.rest_api.services;

import com.ecomeerce.rest_api.exception.EntityDoesNotExist;
import com.ecomeerce.rest_api.models.Product;
import com.ecomeerce.rest_api.models.ProductPromotion;
import com.ecomeerce.rest_api.projections.ProductPromotionProjection;
import com.ecomeerce.rest_api.repositories.ProductPromotionRepository;
import com.ecomeerce.rest_api.repositories.ProductRepository;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class ProductPromotionService extends BaseService<ProductPromotion> {
    private final ProductPromotionRepository productPromotionRepository;
    private final ProductService productService;

    @Autowired
    public ProductPromotionService(ProductPromotionRepository dataBaseRepository,ProductService productService, Validator validator) {
        super(dataBaseRepository, validator);
        this.productPromotionRepository = dataBaseRepository;
        this.productService = productService;
    }

    @Override
    public ProductPromotion create(ProductPromotion entity) {
        Product product = productService.readById(entity.getProduct().getId());
        product.setPromotion(true);
        productService.updateById(product.getId(),product);
        return super.create(entity);
    }

    @Override
    public void deleteById(UUID id) {
        super.deleteById(id);
        Product product = productService.findByProductPromotionId(id);
        product.setPromotion(false);
        productService.updateById(product.getId(),product);
    }

    public Page<ProductPromotionProjection> readByPromotionId(UUID id, Pageable pageable){

        return productPromotionRepository.getByPromotionId(id,pageable)
                .orElseThrow(EntityDoesNotExist::new);
    }
}
