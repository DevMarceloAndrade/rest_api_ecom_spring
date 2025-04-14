package com.ecomeerce.rest_api.projections;

import com.ecomeerce.rest_api.enums.UserRole;
import java.util.UUID;

public interface UserProjection {
    UUID getId();
    String getFirstName();
    String getLastName();
    String getEmail();
    UserRole getRole();
    String getPassword();
}
