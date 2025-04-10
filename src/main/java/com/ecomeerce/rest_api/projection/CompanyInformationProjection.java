package com.ecomeerce.rest_api.projection;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.UUID;
@JsonPropertyOrder({"id", "cnpj", "email", "phone", "phoneUrl", "address", "addressUrl", "instagramUrl"})
public interface CompanyInformationProjection {
    UUID getId();
    String getName();
    String getCnpj();
    String getEmail();
    String getPhone();
    String getPhoneUrl();
    String getAddress();
    String getAddressUrl();
    String getInstagramUrl();
}
