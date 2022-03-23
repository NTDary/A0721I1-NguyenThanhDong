package com.codegym.blogajax.controller;

import com.codegym.blogajax.model.Blog;
import com.codegym.blogajax.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import java.util.Optional;

@RestController
@RequestMapping("/api-blog")
public class BlogAPI {
    @Autowired
    private IBlogService blogService;

    //    @RequestParam(name = "searchText", required = false, defaultValue = "") String text
    @GetMapping("")
    public ResponseEntity<Iterable<Blog>> allBlog() {
        return new ResponseEntity<>(blogService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/search/{textS}")
    public ResponseEntity<Iterable<Blog>> searchBlog(@PathVariable(name = "textS", required = false) String textS) {
        String check =  StringUtils.isEmpty(textS) ? "" : textS;
            return new ResponseEntity<>(blogService.search(check), HttpStatus.OK);

    }

    @PostMapping("")
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) {
        return new ResponseEntity<>(blogService.save(blog), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> deleteBlog(@PathVariable Long id) {
        Optional<Blog> blogOptional = blogService.findById(id);
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            blogService.delete(id);
            return new ResponseEntity<>(blogOptional.get(), HttpStatus.OK);
        }
    }
}
