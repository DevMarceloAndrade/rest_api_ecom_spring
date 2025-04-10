package com.ecomeerce.rest_api.component;

import com.ecomeerce.rest_api.models.User;
import com.ecomeerce.rest_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserIdToEntityConverter extends DataConverterById<User>{

    @Autowired
    public UserIdToEntityConverter(UserService baseService) {
        super(baseService);
    }
}
