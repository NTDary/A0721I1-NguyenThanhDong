package com.code.gym.controller;

import com.code.gym.model.Test;
import com.code.gym.repository.ITestRepository;
import com.code.gym.service.ITestService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class TestController {
    @Autowired
    private ITestService testService;
    @GetMapping("")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("test", new Test());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView save(@Valid Test test, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView("list");
        if(bindingResult.hasFieldErrors()){
            modelAndView = new ModelAndView("list");
            return modelAndView;
        }else
            testService.saveTest(test);
        return modelAndView;

    }

}
