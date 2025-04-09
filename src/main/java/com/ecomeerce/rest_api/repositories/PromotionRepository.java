package com.ecomeerce.rest_api.repositories;

import com.ecomeerce.rest_api.models.Promotion;
import com.ecomeerce.rest_api.projection.PromotionProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PromotionRepository extends DataBaseRepository<Promotion>{

    @Query("SELECT p FROM Promotion p WHERE p.id = :id")
    Optional<PromotionProjection> findByIdStandardType(@Param("id") UUID id);

    @Query("SELECT p FROM Promotion p")
    Optional<Page<PromotionProjection>> findAllStandardType(Pageable pageable);
}
