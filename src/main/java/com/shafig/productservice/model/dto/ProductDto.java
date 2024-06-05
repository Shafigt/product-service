package com.shafig.productservice.model.dto;

import com.shafig.productservice.model.enumerated.ProductCategory;
import lombok.Data;

@Data
public class ProductDto {
    private String name;
    private ProductCategory category;
}
