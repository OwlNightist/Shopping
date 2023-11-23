package com.example.shopping.controller;

import com.example.shopping.dto.*;
import com.example.shopping.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTOResponse> getProductById(@PathVariable int id) {
        ProductDTOResponse productDTOResponse = productService.getProductById(id);
            return new ResponseEntity<>(productDTOResponse, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<ProductDTOResponse>> getAllProducts() {
        List<ProductDTOResponse> productDTOResponse = productService.getProductList();
            return new ResponseEntity<>(productDTOResponse, HttpStatus.OK);
    }

    @PostMapping
    public ProductDTOResponse createProduct(@RequestBody ProductDTORequest productDTORequest) {
        return productService.createProduct(productDTORequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductDTOResponse>  deleteProduct(@PathVariable int id) {
        ProductDTOResponse productDTOResponse = productService.deleteProductById(id);
        return new ResponseEntity<>(productDTOResponse, HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTOResponse> updateProduct(@PathVariable int id, @RequestBody ProductUpdateDTORequest productUpdateDTORequest) {
        ProductDTOResponse productDTOResponse = productService.updateProduct(id, productUpdateDTORequest);
        return new ResponseEntity<>(productDTOResponse, HttpStatus.OK);
    }

    @GetMapping("/search")
    public PagingDTOResponse SearchProduct(@ModelAttribute ProductDTOFilter productDTOFilter){
        return productService.searchProduct(productDTOFilter);
    }
}
