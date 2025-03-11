package com.ecomeerce.rest_api.models;

import com.ecomeerce.rest_api.enums.PaymentStatus;
import com.ecomeerce.rest_api.enums.PaymentType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Purchase extends DataBaseModel {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id_")
    private User user;

    @Column(nullable = false,columnDefinition = "JSON")
    private String address;

    @Enumerated
    @Column(length = 20)
    private PaymentType payment_type;

    @Enumerated
    @Column(length = 20)
    private PaymentStatus payment_status;

    @Column
    private String payment_id_mp;

    @Column
    private BigDecimal total_value_products;

    @Column
    private String status;

    @Column(nullable = false,length = 6)
    private BigDecimal shipping_cost;

    public Address getAddress() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return  objectMapper.readValue(this.address, Address.class);
    }

    public void setAddress(String address) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        this.address = objectMapper.writeValueAsString(address);
    }

    public Purchase() {
    }
}
