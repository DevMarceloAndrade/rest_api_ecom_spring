package com.ecomeerce.rest_api.repositories;

import com.ecomeerce.rest_api.models.Promotion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PromotionRepository extends DataBaseRepository<Promotion>{

    @Query("SELECT p FROM Promotion p LEFT JOIN FETCH p.products_promotion LEFT JOIN FETCH p.thumbnail WHERE p.id = :id")
    Promotion findByIdWithRelations(@Param("id") UUID id);
}
