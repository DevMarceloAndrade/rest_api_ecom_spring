package com.ecomeerce.rest_api.component;

import com.ecomeerce.rest_api.models.SubCategory;
import com.ecomeerce.rest_api.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubCategoryIdToEntityConverter extends DataConverterById<SubCategory>{

    @Autowired
    public SubCategoryIdToEntityConverter(BaseService<SubCategory> baseService) {
        super(baseService);
    }
}
