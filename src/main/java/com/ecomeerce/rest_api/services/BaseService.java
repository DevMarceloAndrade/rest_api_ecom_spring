package com.ecomeerce.rest_api.services;
import com.ecomeerce.rest_api.exception.EntityDoesNotExist;
import com.ecomeerce.rest_api.exception.InvalidEntityException;
import com.ecomeerce.rest_api.repositories.DataBaseRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class BaseService<T> {

    protected final DataBaseRepository<T> dataBaseRepository;
    private final Validator validator;

    @Autowired
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
    public T create(T entity){
        validateEntity(entity);
        return dataBaseRepository.save(entity);
    }

    @Transactional(readOnly = true)
    public T readById(UUID id){
        return dataBaseRepository.findById(id)
                .orElseThrow(EntityDoesNotExist::new);
    }

    @Transactional(readOnly = true)
    public Page<T> readAll(Pageable pageable){

        return dataBaseRepository.findAll(pageable);
    }

    @Transactional
    public T updateById(UUID id, T entity){
            checkEntityById(id);
            return dataBaseRepository.save(entity);
    }

    @Transactional
    public void deleteById(UUID id){
        checkEntityById(id);
        dataBaseRepository.deleteById(id);
    }

    @Transactional
    public void deleteMultipleById(List<UUID> ids){
        dataBaseRepository.deleteAllById(ids);
    }

}
