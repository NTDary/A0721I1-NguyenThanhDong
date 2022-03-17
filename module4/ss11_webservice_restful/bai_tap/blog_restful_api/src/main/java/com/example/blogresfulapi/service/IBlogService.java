package com.example.blogresfulapi.service;

import com.example.blogresfulapi.model.Blog;

public interface IBlogService extends IGeneralService<Blog> {
    Iterable<Blog> findByCategory_Id(Long id);
}
