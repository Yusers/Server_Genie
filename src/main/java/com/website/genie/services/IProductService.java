package com.website.genie.services;

import com.website.genie.dto.ProductDTO;
import com.website.genie.entities.ProductEntity;

import java.util.List;

public interface IProductService {
    ProductDTO save(ProductDTO productDTO);
    List<ProductDTO> findAll();

    ProductDTO findById(long id);

    ProductDTO saveProduct(ProductDTO productDTO);

    String deleteProduct(long id);

}
