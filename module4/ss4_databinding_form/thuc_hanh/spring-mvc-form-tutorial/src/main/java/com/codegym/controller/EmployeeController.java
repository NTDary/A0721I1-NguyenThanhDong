package com.codegym.controller;

import com.codegym.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class EmployeeController {
//    @RequestMapping(value = "showForm", method = RequestMethod.GET)
//    public String showForm(ModelMap model) {
//        model.addAttribute("employee", new Employee());
//        return "employee/create";
//    }
    @GetMapping("showForm")
    public String showForm(ModelMap model){
        model.addAttribute("employee", new Employee());
        return "employee/create";
    }
//    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
//    public String submit(@ModelAttribute("employee") Employee employee, ModelMap model) {
//        model.addAttribute("name", employee.getName());
//        model.addAttribute("contactNumber", employee.getContactNumber());
//        model.addAttribute("id", employee.getId());
//        return "employee/info";
//    }
    @PostMapping("addEmployee")
    public String submit(@ModelAttribute("employee") Employee employee, ModelMap model){
        //@ModelAttribute("employee") lay data nhap tu form create truyen vao doi tuong employee

        //Goi cac thuoc tinh trong doi tuong employee
        model.addAttribute("name", employee.getName());
        model.addAttribute("contactNumber", employee.getContactNumber());
        model.addAttribute("id", employee.getId());
        return "employee/info";
    }
}
