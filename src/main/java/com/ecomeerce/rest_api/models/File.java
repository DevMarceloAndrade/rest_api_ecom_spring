package com.ecomeerce.rest_api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class File extends DataBaseModel{

    @Column(nullable = false)
    private String file_name;

    @Column(nullable = false)
    private String file_downloadUri;

    @Column(nullable = false)
    private String file_targetLocation;

    @Column(nullable = false)
    private String file_type;

    @Column(nullable = false)
    private Long file_size;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne(mappedBy = "thumbnail")
    private Product product;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product_id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne(mappedBy = "thumbnail")
    private Promotion promotion;

    public File(String file_name, String file_type, Long file_size) {
        this.file_name = file_name;
        this.file_type = file_type;
        this.file_size = file_size;
    }

    @PreRemove
    private void preRemove(){
        if(promotion!=null) promotion.setThumbnail(null);
        if (product != null) product.setThumbnail(null);
        if(product_id !=null)setProduct_id(null);
    }
}
