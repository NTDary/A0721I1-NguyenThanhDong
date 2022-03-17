package com.example.blogresfulapi.controller;

import com.example.blogresfulapi.model.Blog;
import com.example.blogresfulapi.model.Category;
import com.example.blogresfulapi.service.IBlogService;
import com.example.blogresfulapi.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categorys")
public class CategoryController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<Iterable<Category>> findAllCategory() {
        List<Category> categories = (List<Category>) categoryService.findAll();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id, @RequestBody Category category){
        Optional<Category> categoryOptional = categoryService.findById(id);
        if(!categoryOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(categoryOptional.get(),HttpStatus.OK);
        }
    }
    @PostMapping
    public ResponseEntity<Category> saveCategory(@RequestBody Category category){
        return new ResponseEntity<>(categoryService.save(category),HttpStatus.OK);
    }
    @PostMapping("/{id}")
    public ResponseEntity<Category> upadateCategory(@PathVariable Long id, @RequestBody Category category){
        Optional<Category> categoryOptional = categoryService.findById(id);
        if(!categoryOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            category.setId(categoryOptional.get().getId());
            return new ResponseEntity<>(categoryService.save(category),HttpStatus.OK);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable Long id){
        Optional<Category> categoryOptional = categoryService.findById(id);
        if(!categoryOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            List<Blog> blogs = (List<Blog>) blogService.findAll();
            if(!blogs.isEmpty()){
                for(Blog b : blogs){
                    if(b.getCategory().getId().equals(id)){
                        blogService.delete(b.getId());
                    }
                }
                categoryService.delete(id);
                return new ResponseEntity<>(categoryOptional.get(),HttpStatus.OK);
            }else {
                categoryService.delete(id);
                return  new ResponseEntity<>(categoryOptional.get(),HttpStatus.OK);
            }
        }

    }
}
