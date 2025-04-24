package com.ecomeerce.rest_api.repositories;

import com.ecomeerce.rest_api.enums.UserRole;
import com.ecomeerce.rest_api.models.User;
import com.ecomeerce.rest_api.projections.UserProjection;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends DataBaseRepository<User> {

    Optional<UserProjection> findByEmail(String email);

    Optional<UserProjection> findByRole(UserRole role);
}
