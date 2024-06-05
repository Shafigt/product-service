package com.shafig.productservice.service;

import com.shafig.productservice.model.dto.ProductDto;
import com.shafig.productservice.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    Long saveProduct(ProductDto productDto);
    List<ProductDto> searchProduct(String key, String value);

}
