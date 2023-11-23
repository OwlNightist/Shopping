package com.example.shopping.service;

import com.example.shopping.dto.*;

import java.util.List;

public interface ProductService {
    ProductDTOResponse getProductById(int id);

    List<ProductDTOResponse> getProductList();

    ProductDTOResponse createProduct(ProductDTORequest productDTORequest);

    ProductDTOResponse deleteProductById(int id);

    ProductDTOResponse updateProduct(int id, ProductUpdateDTORequest productUpdateDTORequest);

    PagingDTOResponse searchProduct(ProductDTOFilter productDTOFilter);
}
