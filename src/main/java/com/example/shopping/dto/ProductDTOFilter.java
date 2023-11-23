package com.example.shopping.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProductDTOFilter {
    Integer pageIndex = 1;
    Integer pageSize = 8;
    Integer categoryId;
    Integer brandId;
    Double priceFrom= 0d;
    Double priceTo = Double.MAX_VALUE;
    String sortByPrice;
    String name;
}
