package com.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @Autowired
    private Hello hello;
    @RequestMapping("hello")
    public String hello(){
        String str = hello.getNameTest();
        return str;
    }
}
