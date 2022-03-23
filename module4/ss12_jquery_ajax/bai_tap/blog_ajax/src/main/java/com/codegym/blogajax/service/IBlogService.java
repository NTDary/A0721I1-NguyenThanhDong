package com.codegym.blogajax.service;

import com.codegym.blogajax.model.Blog;

public interface IBlogService extends IGeneralService<Blog> {
    Iterable<Blog> search(String text);
}
