package com.shafig.productservice.model.entity;

import com.shafig.productservice.model.enumerated.ProductCategory;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private ProductCategory category;
    private Double price;

}
