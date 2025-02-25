package com.ecomeerce.rest_api.services;

import com.ecomeerce.rest_api.models.User;
import com.ecomeerce.rest_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User>{

    @Autowired
    public UserService(UserRepository dataBaseRepository) {
        super(dataBaseRepository);
    }
}
