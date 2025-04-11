package com.ecomeerce.rest_api.services;
import com.ecomeerce.rest_api.models.User;
import com.ecomeerce.rest_api.repositories.UserRepository;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User>{

    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository dataBaseRepository, Validator validator, PasswordEncoder passwordEncoder) {
        super(dataBaseRepository, validator);
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User create(User entity) {
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return super.create(entity);
    }

}
