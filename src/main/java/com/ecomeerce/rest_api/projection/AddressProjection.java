package com.ecomeerce.rest_api.projection;

import java.util.UUID;

public interface AddressProjection {
    UUID getId();
    String getCep();
    String getState();
    String getCity();
    String getNeighborhood();
    String getStreet();
    String getHouseNumber();
    String getComplement();
    String getReferencePoint();
    Boolean getActive();
}
