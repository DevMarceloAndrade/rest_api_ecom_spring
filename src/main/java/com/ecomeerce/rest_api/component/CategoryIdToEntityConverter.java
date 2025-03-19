package com.ecomeerce.rest_api.component;

import com.ecomeerce.rest_api.models.Category;
import com.ecomeerce.rest_api.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryIdToEntityConverter extends DataConverterById<Category>{

    @Autowired
    public CategoryIdToEntityConverter(BaseService<Category> baseService) {
        super(baseService);
    }
}
