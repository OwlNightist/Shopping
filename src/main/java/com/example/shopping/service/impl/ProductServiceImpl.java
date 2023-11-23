package com.example.shopping.service.impl;

import com.example.shopping.dto.*;
import com.example.shopping.entity.Product.Product;
import com.example.shopping.exception.ShopException;
import com.example.shopping.mapper.ProductMapper;
import com.example.shopping.repository.ProductRepository;
import com.example.shopping.repository.criteria.ProductRepositoryCriteria;
import com.example.shopping.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;
    ProductMapper productMapper;
    ProductRepositoryCriteria productRepositoryCriteria;

    @Override
    public ProductDTOResponse getProductById(int id) {
        Product product = productRepository.findById(id).orElseThrow(() -> ShopException.notFoundException("Product does not exist"));
        return productMapper.toProductDTOResponse(product);
    }

    @Override
    public List<ProductDTOResponse> getProductList() {
        List<Product> productList = productRepository.findAll();
        return productList.stream()
                .map(productMapper::toProductDTOResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTOResponse createProduct(ProductDTORequest productDTORequest) {
        Product product = productMapper.toProduct(productDTORequest);
        product.setCreateDate(new Date());
        product.setDelete(false);
        product = productRepository.save(product);
        return productMapper.toProductDTOResponse(product);
    }

    @Override
    public ProductDTOResponse deleteProductById(int id) {
        Product product = productRepository.findById(id).orElseThrow(() -> ShopException.notFoundException("Product does not exist"));
        product.setDelete(true);
        productRepository.save(product);
        return productMapper.toProductDTOResponse(product);
    }

    @Override
    public ProductDTOResponse updateProduct(int id, ProductUpdateDTORequest productUpdateDTORequest) {
        Product product = productRepository.findById(id).orElseThrow(() -> ShopException.notFoundException("Product does not exist"));
        product = productMapper.toProduct(productUpdateDTORequest, product);
        product.setUpdateDate(new Date());
        productRepository.save(product);
        return productMapper.toProductDTOResponse(product);
    }
    @Override
    public PagingDTOResponse searchProduct(ProductDTOFilter productDTOFilter) {
        return productRepositoryCriteria.search(productDTOFilter);
    }

}
