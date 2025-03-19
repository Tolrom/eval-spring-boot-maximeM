package com.maxime.evalspring.service;

import com.maxime.evalspring.exception.NoCategoryFoundException;
import com.maxime.evalspring.exception.CategoryAlreadyExistsException;
import com.maxime.evalspring.exception.CategoryNotFoundException;
import com.maxime.evalspring.model.Category;
import com.maxime.evalspring.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Iterable<Category> getAllCategories() {
        Iterable<Category> categories =  categoryRepository.findAll();
        if(!categories.iterator().hasNext()) {
            throw new NoCategoryFoundException();
        }
        return categories;
    }

    public Category getCategoryById(int id) {
        return categoryRepository.findById(id).orElseThrow(
                () -> new CategoryNotFoundException(id)
        );
    }

    public Category addCategory(Category category) {
        if(categoryRepository.existsByLabel(category.getLabel())) {
            throw new CategoryAlreadyExistsException(category.getLabel());
        }
        return categoryRepository.save(category);
    }
}
