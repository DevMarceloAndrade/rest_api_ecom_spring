package com.ecomeerce.rest_api.repositories;

import com.ecomeerce.rest_api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends DataBaseRepository<User> {

}
