package com.ecomeerce.rest_api.repositories;

import com.ecomeerce.rest_api.models.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends DataBaseRepository<User> {
}
