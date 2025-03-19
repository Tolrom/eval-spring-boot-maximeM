package com.maxime.evalspring.repository;

import com.maxime.evalspring.model.Category;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
    boolean existsByLabel(@NotEmpty(message = "Please enter a label") @Size(min = 2, message = "Must be at least 2 characters long") String label);
}
