package com.website.genie.convert;

import com.website.genie.dto.ProductDTO;
import com.website.genie.entities.CategoryEntity;
import com.website.genie.entities.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ConvertUtil {
    public ProductDTO toDTO(ProductEntity p) {
        ProductDTO product = new ProductDTO(p.getId(), p.getCreateDate(), p.getModifiedBy(), p.getModifiedDate(), p.getTitle(), p.getCategory().getCode(), p.getMaterial(), p.getFit(), p.getPrice(), p.getImageUrl(), p.getDescription());
        return product;
    }

    public ProductEntity toEntity(ProductDTO p) {
        ProductEntity product = new ProductEntity();
        product.setTitle(p.getTitle());
        product.setMaterial(p.getMaterial());
        product.setFit(p.getFit());
        product.setPrice(p.getPrice());
        product.setImageUrl(p.getImageUrl());
        product.setDescription(p.getDescription());
        return product;
    }
}
