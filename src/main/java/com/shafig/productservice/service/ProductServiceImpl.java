package com.shafig.productservice.service;

import com.shafig.productservice.model.dto.ProductDto;
import com.shafig.productservice.model.entity.Product;
import com.shafig.productservice.repository.ProductRepository;
import com.shafig.productservice.repository.ProductSpecification;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Override
    public List<ProductDto> searchProduct(String key, String value) {
        Type listType = new TypeToken<List<ProductDto>>(){}.getType();

        if(key == null || value == null){
            return new ModelMapper().map(repository.findAll(),listType);
        }
        Specification<Product> spec = ProductSpecification.hasAttribute(key, value);
        List<Product> products =  repository.findAll(spec);
        System.out.println(products);


        return new ModelMapper().map(products,listType);
    }

    @Override
    public List<Product> getProducts() {
        return repository.findAll();
    }

    @Override
    public Long saveProduct(ProductDto productDto) {
        var product = repository.save(new ModelMapper().map(productDto, Product.class));
        return product.getId();
    }

    public List<Product> searchProducts(String key, String value) {
        Specification<Product> spec = ProductSpecification.hasAttribute(key, value);
        return repository.findAll(spec);
    }


}
