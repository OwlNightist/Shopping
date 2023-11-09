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
public class ProductUpdateDTORequest {
    String name;
    double price;
    String sku;
    String imageURL;
    int quantity;
    String description;

}
