package com.ecomeerce.rest_api.repositories;

import com.ecomeerce.rest_api.models.Product;
import com.ecomeerce.rest_api.models.SubCategory;
import com.ecomeerce.rest_api.projection.ProductProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends DataBaseRepository<Product>{

    @Query("SELECT p FROM Product p WHERE p.id = :id")
    Optional<ProductProjection> findByIdStandardType(@Param("id") UUID id);

    @Query("SELECT p FROM Product p WHERE p.subCategory.id = :id")
    Optional<Page<ProductProjection>> findAllBySubCategory(@Param("id") UUID id, Pageable pageable);

}
