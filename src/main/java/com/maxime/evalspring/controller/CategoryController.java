package com.maxime.evalspring.controller;

import com.maxime.evalspring.model.Category;
import com.maxime.evalspring.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Category> showCategories() {

        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Category showCategoryById(@PathVariable int id) {

        return categoryService.getCategoryById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Category addCategory(@Valid @RequestBody Category category) {

        return categoryService.addCategory(category);
    }

}
