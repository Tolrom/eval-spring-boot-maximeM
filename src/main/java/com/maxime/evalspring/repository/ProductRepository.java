package com.maxime.evalspring.repository;

import com.maxime.evalspring.model.Product;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    boolean existsByName(@NotEmpty(message = "Please enter a name!") @Size(min = 2, max = 50, message = "Name length must be between 2 and 50") String name);
}
