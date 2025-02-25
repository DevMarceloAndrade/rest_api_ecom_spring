package com.ecomeerce.rest_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface DataBaseRepository<T> extends JpaRepository<T, UUID> {
}
