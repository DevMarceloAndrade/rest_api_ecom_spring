package com.ecomeerce.rest_api.models;

import com.ecomeerce.rest_api.enums.PaymentStatus;
import com.ecomeerce.rest_api.enums.PaymentType;
import com.ecomeerce.rest_api.exception.InvalidJsonFormatException;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.math.BigDecimal;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Purchase extends DataBaseModel {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id_", nullable = false)
    private User user;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "purchase", fetch = FetchType.LAZY)
    private List<ProductPurchased> products_purchased;

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

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal shipping_cost;

    public Address getAddress() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return  objectMapper.readValue(this.address, Address.class);
        }catch (JsonProcessingException e){
            throw new InvalidJsonFormatException("The address format must be Json");
        }
    }

    public void setAddress(String address) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            this.address = objectMapper.writeValueAsString(address);
        }catch (JsonProcessingException e){
            throw new InvalidJsonFormatException("The address format must be Json");
        }
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = PaymentType.valueOf(payment_type.toUpperCase());
    }

    public void setPayment_status(String payment_status) {
        this.payment_status = PaymentStatus.valueOf(payment_status.toUpperCase());
    }

    public Purchase() {
    }
}
