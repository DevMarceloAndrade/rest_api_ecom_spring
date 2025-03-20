package com.ecomeerce.rest_api.component;

import com.ecomeerce.rest_api.services.BaseService;
import com.fasterxml.jackson.databind.util.StdConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


public class DataConverterById<T> extends StdConverter<UUID, T> {

    private final BaseService<T> baseService;

    @Autowired
    public DataConverterById(BaseService<T> baseService) {
        this.baseService = baseService;
    }

    @Override
    @Transactional
    public T convert(UUID id){
        return baseService.readById(id);
    }
}
