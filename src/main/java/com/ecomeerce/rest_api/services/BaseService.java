package com.ecomeerce.rest_api.services;

import com.ecomeerce.rest_api.repositories.DataBaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BaseService<T> {

    private final DataBaseRepository<T> dataBaseRepository;

    public BaseService(DataBaseRepository<T> dataBaseRepository) {
        this.dataBaseRepository = dataBaseRepository;
    }

    @Transactional
    public Optional<T> create( T entity ){
        return Optional.of(dataBaseRepository.save(entity));
    }
}
