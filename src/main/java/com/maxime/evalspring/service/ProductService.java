package com.maxime.evalspring.service;

import com.maxime.evalspring.exception.NoProductFoundException;
import com.maxime.evalspring.exception.ProductAlreadyExistsException;
import com.maxime.evalspring.exception.ProductNotFoundException;
import com.maxime.evalspring.model.Product;
import com.maxime.evalspring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> getAllProducts() {
        Iterable<Product> products =  productRepository.findAll();
        if(!products.iterator().hasNext()) {
            throw new NoProductFoundException();
        }
        return products;
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).orElseThrow(
                () -> new ProductNotFoundException(id)
        );
    }

    public Product addProduct(Product product) {
        if(productRepository.existsByName(product.getName())) {
            throw new ProductAlreadyExistsException(product.getName());
        }
        return productRepository.save(product);
    }

}
