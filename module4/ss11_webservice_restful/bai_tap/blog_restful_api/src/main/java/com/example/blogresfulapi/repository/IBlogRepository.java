package com.example.blogresfulapi.repository;

import com.example.blogresfulapi.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository<Blog,Long> {
    Iterable<Blog> findByCategory_Id(Long id);
}
