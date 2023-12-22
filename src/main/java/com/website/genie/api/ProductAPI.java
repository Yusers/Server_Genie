package com.website.genie.api;

import com.website.genie.dto.ProductDTO;
import com.website.genie.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductAPI {

    @Autowired
    private IProductService productService;

    @GetMapping("/product")
    public List<ProductDTO> getProduct() {
        return productService.findAll();
    }

    @GetMapping("/product/{id}")
    public ProductDTO getProductDetail(@PathVariable("id") Long id) {
        return productService.findById(id);
    }

    @PostMapping("/product")
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        return productService.saveProduct(productDTO);
    }

    @PutMapping("/product/{id}")
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO, @PathVariable("id") long id) {
        productDTO.setId(id);
        return productService.saveProduct(productDTO);
    }

    @DeleteMapping("/product/{id}")
    public String deleteProduct(@PathVariable("id") long id) {
        return productService.deleteProduct(id);
    }
}
