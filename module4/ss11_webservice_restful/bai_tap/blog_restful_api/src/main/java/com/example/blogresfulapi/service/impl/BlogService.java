package com.example.blogresfulapi.service.impl;

import com.example.blogresfulapi.model.Blog;
import com.example.blogresfulapi.repository.IBlogRepository;
import com.example.blogresfulapi.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public void delete(Long id) {
      blogRepository.deleteById(id);
    }

    @Override
    public Iterable<Blog> findByCategory_Id(Long id) {
        return blogRepository.findByCategory_Id(id);
    }
}
