package com.ecomeerce.rest_api.models;

import com.ecomeerce.rest_api.component.ProductIdToEntityConverter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class File extends DataBaseModel{

    @Column(nullable = false)
    private String name;

    @Column(name = "download_uri", nullable = false)
    private String downloadUri;

    @Column(name = "target_location", nullable = false)
    private String targetLocation;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private Long size;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne(mappedBy = "thumbnail")
    private Product product;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @JsonDeserialize(converter = ProductIdToEntityConverter.class)
    private Product productId;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "thumbnail")
    private Promotion promotion;

    public File(String name, String type, Long size) {
        this.name = name;
        this.type = type;
        this.size = size;
    }

    public File() {
    }

    @PreRemove
    private void preRemove(){
        if(promotion!=null) promotion.setThumbnail(null);
        if (product != null) product.setThumbnail(null);
        if(productId !=null)setProductId(null);
    }
}
