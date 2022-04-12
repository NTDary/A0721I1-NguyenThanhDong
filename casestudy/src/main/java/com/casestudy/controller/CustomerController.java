package com.casestudy.controller;

import com.casestudy.model.customer.Customer;
import com.casestudy.model.employee.Employee;
import com.casestudy.service.customer.ICustomerService;
import com.casestudy.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("")
    public ModelAndView listCustomer(@RequestParam(name = "nameC", required = false, defaultValue = "") String nameCustomer, @PageableDefault(size = 2) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("customer/list");
//        Page<Employee> page = employeeService.findAll(pageable);
        Page<Customer> page = customerService.searchByName(nameCustomer, pageable);
        long totalItems = page.getTotalElements();
        modelAndView.addObject("currentPage",pageable.getPageNumber() + 1);
        modelAndView.addObject("totalItems",totalItems);
        modelAndView.addObject("nameC",nameCustomer);
        modelAndView.addObject("customers",page);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("type",customerTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid Customer customer, BindingResult bindingResult) {
        if(bindingResult.hasFieldErrors()){
            return new ModelAndView("customer/create");
        }
        ModelAndView modelAndView = new ModelAndView("redirect:/customer");
        customerService.save(customer);
        return modelAndView;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditForm(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("customer/edit");
        Optional<Customer> customer = customerService.findById(id);
        if(customer.isPresent()){
            modelAndView.addObject("customer",customer.get());
            modelAndView.addObject("type",customerTypeService.findAll());
            return modelAndView;
        }else {
            return new ModelAndView("error404");
        }
    }
    @PostMapping("/update")
    public ModelAndView updateCustomer(Customer customer, RedirectAttributes redirectAttributes){
        ModelAndView modelAndView = new ModelAndView("redirect:/customer");
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message","Updated successfully");
        return modelAndView;
    }
    @GetMapping("/{id}/delete")
    public ModelAndView deleteCustomer(@PathVariable Long id){
        Optional<Customer> customer = customerService.findById(id);
        if(customer.isPresent()){
            ModelAndView modelAndView = new ModelAndView("redirect:/customer");
            customerService.remove(id);
            return modelAndView;
        }else{
            return new ModelAndView("error404");
        }
    }


}
