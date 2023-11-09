package com.example.shopping.controller;

import com.example.shopping.dto.ProductDTORequest;
import com.example.shopping.dto.ProductDTOResponse;
import com.example.shopping.dto.ProductUpdateDTORequest;
import com.example.shopping.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    ProductService productService;

    @GetMapping("/{id}")
    public ProductDTOResponse getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @GetMapping
    public List<ProductDTOResponse> getProducts() {
        return productService.getProductList();
    }

    @PostMapping
    public ProductDTOResponse createProduct(@RequestBody ProductDTORequest productDTORequest) {
        return productService.createProduct(productDTORequest);
    }

    @DeleteMapping("/{id}")
    public ProductDTOResponse deleteProduct(@PathVariable int id) {
        return productService.deleteProductById(id);
    }

    @PutMapping("/{id}")
    public ProductDTOResponse updateProduct(@PathVariable int id, @RequestBody ProductUpdateDTORequest productUpdateDTORequest) {
        return productService.updatePRoduct(id,productUpdateDTORequest);
    }
}
