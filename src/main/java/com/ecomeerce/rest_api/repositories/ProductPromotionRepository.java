package com.ecomeerce.rest_api.repositories;

import com.ecomeerce.rest_api.models.ProductPromotion;
import com.ecomeerce.rest_api.projection.ProductPromotionProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductPromotionRepository extends DataBaseRepository<ProductPromotion>{

    @Query("SELECT p FROM ProductPromotion p LEFT JOIN FETCH p.promotion WHERE p.promotion.id = :id")
    Optional<List<ProductPromotionProjection>> getByPromotionId(@Param("id") UUID id );
}
