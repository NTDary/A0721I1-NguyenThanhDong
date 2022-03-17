package com.example.blogresfulapi.controller;

import com.example.blogresfulapi.model.Blog;
import com.example.blogresfulapi.service.IBlogService;
import com.example.blogresfulapi.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<Iterable<Blog>> findAllBlogs() {
        List<Blog> blogs = (List<Blog>) blogService.findAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        System.out.println(blogs);
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Blog> findById(@PathVariable Long id){
        Optional<Blog> blog = blogService.findById(id);
        if(!blog.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(blog.get(),HttpStatus.OK);
        }
    }
    @PostMapping
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog){
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable Long id, @RequestBody Blog blog){
        Optional<Blog> blogOptional = blogService.findById(id);
        if(!blogOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            //blog khi update khong truyen vao id, thi phai setId can de update
            blog.setId(blogOptional.get().getId());
            return new ResponseEntity<>(blogService.save(blog),HttpStatus.OK);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> deleteBlog(@PathVariable Long id){
        Optional<Blog> blogOptional = blogService.findById(id);
        if(!blogOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            blogService.delete(id);
            return new ResponseEntity<>(blogOptional.get(),HttpStatus.OK);
        }
    }
}
