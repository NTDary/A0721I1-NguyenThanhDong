package com.casestudy.controller;

import com.casestudy.model.contract.Contract;
import com.casestudy.model.customer.Customer;
import com.casestudy.service.contract.IAttachServiceS;
import com.casestudy.service.contract.IContractService;
import com.casestudy.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IContractService contractService;
    @Autowired
    private IAttachServiceS attachServiceS;

    @GetMapping("")
    public ModelAndView listCustomer(@RequestParam(name = "nameC", required = false, defaultValue = "") String name, @PageableDefault(size = 5) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("home");
//        Page<Employee> page = employeeService.findAll(pageable);
        Page<Customer> page = customerService.searchCS(name,pageable);
        long totalItems = page.getTotalElements();
        modelAndView.addObject("currentPage",pageable.getPageNumber() + 1);
        modelAndView.addObject("totalItems",totalItems);
        modelAndView.addObject("nameC",name);
        modelAndView.addObject("useServices",page);
        return modelAndView;
    }
}
