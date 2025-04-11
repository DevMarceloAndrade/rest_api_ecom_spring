package com.ecomeerce.rest_api.repositories;

import com.ecomeerce.rest_api.models.ProductPromotion;
import com.ecomeerce.rest_api.projections.ProductPromotionProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductPromotionRepository extends DataBaseRepository<ProductPromotion>{

    @Query("SELECT p FROM ProductPromotion p WHERE p.promotion.id = :id")
    Optional<Page<ProductPromotionProjection>> getByPromotionId(@Param("id") UUID id, Pageable pageable);
}
