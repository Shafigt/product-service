package com.shafig.productservice.repository;

import com.shafig.productservice.model.entity.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {

    public static Specification<Product> hasAttribute(String key, String value) {
        return (root, query, builder) -> builder.equal(root.get(key), value);
    }
}
