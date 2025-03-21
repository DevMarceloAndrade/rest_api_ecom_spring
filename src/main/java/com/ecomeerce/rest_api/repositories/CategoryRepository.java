package com.ecomeerce.rest_api.repositories;

import com.ecomeerce.rest_api.models.Category;
import com.ecomeerce.rest_api.projection.CategoryProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategoryRepository extends DataBaseRepository<Category>{


    @Query("SELECT c FROM Category c LEFT JOIN FETCH sub_categories WHERE c.id = :id")
    Optional<CategoryProjection> findByIdIncludingSubCategories(@Param("id") UUID uuid);
}
