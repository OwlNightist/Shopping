package com.example.shopping.controller;

import com.example.shopping.dto.ProductDTORequest;
import com.example.shopping.dto.ProductDTOResponse;
import com.example.shopping.dto.ProductUpdateDTORequest;
import com.example.shopping.exception.ShopException;
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
        ProductDTOResponse productDTOResponse = productService.updatePRoduct(id, productUpdateDTORequest);
        return new ResponseEntity<>(productDTOResponse, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductDTOResponse>> searchProducts(@RequestParam String keyword) {
        List<ProductDTOResponse> productDTOResponse = productService.searchProduct(keyword);
        if(productDTOResponse.isEmpty()){
            throw  ShopException.notFoundException("No products found with the keyword " + keyword);
        }
        return new ResponseEntity<>(productDTOResponse, HttpStatus.OK);

    }
}
