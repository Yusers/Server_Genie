package com.website.genie.services.impl;

import com.website.genie.convert.ConvertUtil;
import com.website.genie.dto.ProductDTO;
import com.website.genie.entities.CategoryEntity;
import com.website.genie.entities.ProductEntity;
import com.website.genie.repositories.CategoryRepository;
import com.website.genie.repositories.ProductRepository;
import com.website.genie.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ConvertUtil converter;

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        return null;
    }

    @Override
    public List<ProductDTO> findAll() {
        List<ProductEntity> listProducts = repository.findAll();
        List<ProductDTO> products = new ArrayList<>();
        for(ProductEntity product : listProducts) {
            products.add(new ProductDTO(product.getId(), product.getCreateDate(), product.getModifiedBy(), product.getModifiedDate(), product.getTitle(), product.getCategory().getCode(), product.getMaterial(), product.getFit(), product.getPrice(), product.getImageUrl(), product.getDescription()));
        }
        return products;
    }

    @Override
    public ProductDTO findById(long id) {
        Optional<ProductEntity> optionalProduct = repository.findById(id);
        if (optionalProduct.isPresent()) {
            ProductEntity product = optionalProduct.get();
            return converter.toDTO(product);
        } else {
            // Handle the case where the product with the given ID is not found
            // For example, throw an exception or return a default DTO
            return null; // Or throw an exception or return a default DTO
        }
    }

    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {
        if(productDTO == null) return null;
        ProductEntity productEntity = converter.toEntity(productDTO);
        CategoryEntity category = categoryRepository.findOneByCode(productDTO.getCategory());
        productEntity.setCategory(category);
        productDTO = converter.toDTO(repository.save(productEntity));
        return productDTO;
    }

}
