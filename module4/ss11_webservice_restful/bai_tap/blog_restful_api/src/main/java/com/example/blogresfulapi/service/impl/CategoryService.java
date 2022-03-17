package com.example.blogresfulapi.service.impl;

import com.example.blogresfulapi.model.Category;
import com.example.blogresfulapi.repository.ICategoryRepository;
import com.example.blogresfulapi.service.ICategoryService;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }


    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
