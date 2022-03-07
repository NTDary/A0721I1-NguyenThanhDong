package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/list")
    public ModelAndView getBlogList(){
        return new ModelAndView("list","blogs",iBlogService.findAll());
    }

    @GetMapping("")
    public ModelAndView showBlog(){
        return new ModelAndView("home","blogs",iBlogService.findAll());
    }
    @GetMapping("/create")
    public ModelAndView createBlog(){
        return new ModelAndView("create","blog", new Blog());
    }
    @PostMapping("/save")
    public ModelAndView saveBlog(Blog blog, RedirectAttributes redirectAttrs){
        ModelAndView modelAndView = new ModelAndView("redirect:/list");
        iBlogService.save(blog);
        redirectAttrs.addFlashAttribute("message","Added successfully");
        return modelAndView;
    }
    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable Long id){
        Optional<Blog> blog = iBlogService.findById(id);
        if(blog.isPresent()){
            ModelAndView modelAndView = new ModelAndView("redirect:/");
            iBlogService.remove(id);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error404");
            return modelAndView;
        }
    }
//    @PostMapping("/delete")
//    public ModelAndView deleteBlog(Long id){
//        iBlogService.deleteBlog(id);
//    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Blog> blog = iBlogService.findById(id);
        if (blog.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("edit");
            modelAndView.addObject("blog", blog.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error404");
            return modelAndView;
        }
    }
    @PostMapping("/update")
    public ModelAndView updateBlog(Blog blog, RedirectAttributes redirectAttributes){
        ModelAndView modelAndView = new ModelAndView("redirect:/list");
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("message","Updated successfully");
        return modelAndView;
    }
    @GetMapping("/{id}/view")
    public ModelAndView viewBlog(@PathVariable Long id){
        Optional<Blog> blog = iBlogService.findById(id);
        if(blog.isPresent()){
            ModelAndView modelAndView = new ModelAndView("view");
            modelAndView.addObject("blog", blog.get());
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error404");
            return modelAndView;
        }
    }

}
