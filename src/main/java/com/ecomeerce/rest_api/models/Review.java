package com.ecomeerce.rest_api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    private User user;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="product_id", referencedColumnName = "id_", nullable = false)
    private Product product;

    @Column(nullable = false, length = 100)
    private String review_title;

    @Column(nullable = false)
    private String review_text;

    @Column(nullable = false, length = 1)
    @Min(1)
    @Max(5)
    private Integer rating;

    public Review() {
    }
}
