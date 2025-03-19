package com.maxime.evalspring.controller;

import com.maxime.evalspring.model.Product;
import com.maxime.evalspring.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Product> showProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product showProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Product addProduct(@Valid @RequestBody Product product) {
        return productService.addProduct(product);
    }
}
