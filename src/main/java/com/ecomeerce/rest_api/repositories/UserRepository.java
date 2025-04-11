package com.ecomeerce.rest_api.repositories;

import com.ecomeerce.rest_api.models.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends DataBaseRepository<User> {

    Optional<User> findByEmail(String email);
}
