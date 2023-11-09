package com.example.shopping.service;

import com.example.shopping.dto.ProductDTORequest;
import com.example.shopping.dto.ProductDTOResponse;
import com.example.shopping.dto.ProductUpdateDTORequest;

import java.util.List;

public interface ProductService {
    ProductDTOResponse getProductById(int id);

    List<ProductDTOResponse> getProductList();

    ProductDTOResponse createProduct(ProductDTORequest productDTORequest);

    ProductDTOResponse deleteProductById(int id);

    ProductDTOResponse updatePRoduct(int id, ProductUpdateDTORequest productUpdateDTORequest);
}
