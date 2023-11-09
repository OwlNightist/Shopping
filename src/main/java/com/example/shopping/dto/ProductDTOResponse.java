package com.example.shopping.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDTOResponse {
    long id;
    String name;
    double price;
    String sku;
    String imageURL;
    int quantity;
    String description;
    boolean isDelete;
    CategoryDTOResponse category;
    BrandDTOResponse brand;
}
