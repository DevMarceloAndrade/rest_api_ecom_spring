package com.ecomeerce.rest_api.services;
import com.ecomeerce.rest_api.exception.EntityDoesNotExist;
import com.ecomeerce.rest_api.exception.InvalidEntityException;
import com.ecomeerce.rest_api.repositories.DataBaseRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
public class BaseService<T> {

    private final DataBaseRepository<T> dataBaseRepository;
    private final Validator validator;

    public BaseService(DataBaseRepository<T> dataBaseRepository,Validator validator) {
        this.dataBaseRepository = dataBaseRepository;
        this.validator = validator;
    }

    public void checkEntityById(UUID id){
        if(!dataBaseRepository.existsById(id)){
            throw new EntityDoesNotExist();
        }

    }

    private void validateEntity(T entity) {
        Set<ConstraintViolation<T>> violations = validator.validate(entity);
        if (!violations.isEmpty()) {
            throw new InvalidEntityException("Invalid entity: " + violations);
        }
    }

    @Transactional
    public T create( T entity ){
        validateEntity(entity);
        return dataBaseRepository.save(entity);
    }

    @Transactional(readOnly = true)
    public T getById(UUID id){
        return dataBaseRepository.findById(id)
                .orElseThrow(EntityDoesNotExist::new);
    }

    @Transactional
    public T updateById(UUID id, T entity){
            checkEntityById(id);
            validateEntity(entity);
            return dataBaseRepository.save(entity);
    }

    @Transactional
    public String deleteById(UUID id){
        checkEntityById(id);
        dataBaseRepository.deleteById(id);
        return "Successfully deleted";
    }

}
