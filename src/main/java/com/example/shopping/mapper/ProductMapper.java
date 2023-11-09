package com.example.shopping.mapper;

import com.example.shopping.dto.ProductDTORequest;
import com.example.shopping.dto.ProductDTOResponse;
import com.example.shopping.dto.ProductUpdateDTORequest;
import com.example.shopping.entity.Product.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueMappingStrategy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring",nullValueMappingStrategy =  NullValueMappingStrategy.RETURN_DEFAULT)
public interface  ProductMapper {
    ProductDTOResponse toProductDTOResponse(Product product);

    Product toProduct(ProductDTORequest productDTORequest);

    Product toProduct(ProductUpdateDTORequest productUpdateDTORequest, @MappingTarget Product product);


}
