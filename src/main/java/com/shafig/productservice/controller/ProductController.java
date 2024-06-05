package com.shafig.productservice.controller;

import com.shafig.productservice.model.dto.ProductDto;
import com.shafig.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> searchProducts(@RequestParam(required = false) String key,
                                                           @RequestParam(required = false) String value) {
        return ResponseEntity.ok(productService.searchProduct(key, value));
    }

    @PostMapping
    public ResponseEntity<Long> postStudent(@RequestBody ProductDto student) {
        return ResponseEntity.ok(productService.saveProduct(student));
    }}
