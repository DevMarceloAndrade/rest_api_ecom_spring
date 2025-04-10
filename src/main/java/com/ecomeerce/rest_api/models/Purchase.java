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
    private List<ProductPurchased> productsPurchased;

    @Column(nullable = false,columnDefinition = "JSON")
    private String address;

    @Enumerated
    @Column(name = "payment_type", length = 20)
    private PaymentType paymentType;

    @Enumerated
    @Column(name = "payment_status", length = 20)
    private PaymentStatus paymentStatus;

    @Column(name = "payment_id_mp")
    private String paymentIdMp;

    @Column(name = "total_value_products")
    private BigDecimal totalValueProducts;

    @Column
    private String status;

    @Column(name = "shipping_cost", nullable = false, precision = 10, scale = 2)
    private BigDecimal shippingCost;

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

    public void setPaymentType(String paymentType) {
        this.paymentType = PaymentType.valueOf(paymentType.toUpperCase());
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = PaymentStatus.valueOf(paymentStatus.toUpperCase());
    }

    public Purchase() {
    }
}
