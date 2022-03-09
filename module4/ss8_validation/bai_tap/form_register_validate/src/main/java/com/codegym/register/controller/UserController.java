package com.codegym.register.controller;

import com.codegym.register.model.User;
import com.codegym.register.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private IUserService iUserService;
    @GetMapping("")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("user",new User());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView createUser(@Valid User user, RedirectAttributes r, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView("list");
        if(bindingResult.hasFieldErrors()){
            new ModelAndView("create");
            return modelAndView;
        }
        iUserService.saveUser(user);
//        r.addFlashAttribute("messager","Created");
        return modelAndView;
    }
}
