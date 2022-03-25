package com.codegym.blogajax.controller;

import com.codegym.blogajax.model.Blog;
import com.codegym.blogajax.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-blog")
public class BlogAPI {
    private final int ROW_LIMIT = 2;

    @Autowired
    private IBlogService blogService;

    //    @RequestParam(name = "searchText", required = false, defaultValue = "") String text
    @GetMapping("")
    public ResponseEntity<Iterable<Blog>> allBlog() {
        return new ResponseEntity<>(blogService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<Blog>> searchBlog(@RequestParam String textS) {
        List<Blog> blogsList = (List<Blog>) blogService.search(textS);
        if(!blogsList.isEmpty()){
            return new ResponseEntity<>(blogsList, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/load")
    public ResponseEntity<Iterable<Blog>> loadBlog(@RequestParam String row, @RequestParam String textS) {
        List<Blog> temp = (List<Blog>)blogService.search(textS);
        List<Blog> blogList = new ArrayList<>();
        if(!temp.isEmpty()){
            //row = 2 , size = 2 + row --- row = 4, size = 2 + 4
            int numberRow = Integer.parseInt(row);
            for (int i = numberRow; i < numberRow + ROW_LIMIT; i++) {
                if(i < temp.size()){
                    blogList.add(temp.get(i));
                }else {
                    break;
                }
            }
            return new ResponseEntity<>(blogList, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

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
