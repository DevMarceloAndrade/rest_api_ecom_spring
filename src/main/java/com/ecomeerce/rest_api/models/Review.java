package com.ecomeerce.rest_api.models;

import com.ecomeerce.rest_api.component.ProductIdToEntityConverter;
import com.ecomeerce.rest_api.component.UserIdToEntityConverter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Review extends DataBaseModel{

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="user_id", referencedColumnName = "id_" ,nullable = false)
    @JsonDeserialize(converter = UserIdToEntityConverter.class)
    private User user;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="product_id", referencedColumnName = "id_", nullable = false)
    @JsonDeserialize(converter = ProductIdToEntityConverter.class)
    private Product product;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false, length = 1)
    @Min(1)
    @Max(5)
    private Integer rating;

    public Review() {
    }
}
