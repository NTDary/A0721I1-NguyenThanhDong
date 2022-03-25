package com.codegym.blogajax.controller;

import com.codegym.blogajax.model.Blog;
import com.codegym.blogajax.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @GetMapping("")
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("index");
        List<Blog> temp = (List<Blog>)blogService.findAll();
        List<Blog> blogList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            blogList.add(temp.get(i));
        }
        modelAndView.addObject("blogs",blogList);
        return modelAndView;
    }
}
