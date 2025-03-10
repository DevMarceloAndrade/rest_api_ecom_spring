package com.ecomeerce.rest_api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Reviews extends DataBaseModel{

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id_")
    private User user;

    @ManyToOne
    @JoinColumn(name="product_id", referencedColumnName = "id_")
    private Product product;

    @Column(nullable = false, length = 100)
    private String review_title;

    @Column(nullable = false)
    private String review_text;

    @Column(nullable = false, length = 1)
    @Min(1)
    @Max(5)
    private Integer rating;

    public Reviews() {
    }
}
