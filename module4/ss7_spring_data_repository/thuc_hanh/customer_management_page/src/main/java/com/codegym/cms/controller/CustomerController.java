package com.codegym.cms.controller;

import com.codegym.cms.model.Customer;
import com.codegym.cms.model.Province;
import com.codegym.cms.service.ICustomerService;
import com.codegym.cms.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private IProvinceService iProvinceService;


    @GetMapping("")
    public ModelAndView listCustomer(@RequestParam(name = "nameCus", required = false, defaultValue = "") String firstName, @PageableDefault(size = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("list");
        Page<Customer> page = iCustomerService.searchByName(firstName,pageable);
        //Page<Customer> page1 = iCustomerService.findAll(pageable);
        long totalItems = page.getTotalElements();
        modelAndView.addObject("currentPage",pageable.getPageNumber() + 1);
        modelAndView.addObject("totalItems",totalItems);
        modelAndView.addObject("customers",page);
        modelAndView.addObject("nameCus",firstName);

        return modelAndView;
    }



    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("provinces",iProvinceService.findAll());
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView save(Customer customer) {
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        iCustomerService.save(customer);
        return modelAndView;
    }
    @GetMapping("/{id}/edit")
    public ModelAndView showEditForm(@PathVariable Long id){

        Optional<Customer> customer = iCustomerService.findById(id);
        if(customer.isPresent()){
            return new ModelAndView("edit","customer",customer.get());
        }else {
            return new ModelAndView("error404");
        }
    }
    @PostMapping("/update")
    public ModelAndView updateCustomer(Customer customer, RedirectAttributes redirectAttributes){
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("message","Updated successfully");
        return modelAndView;
    }
    @GetMapping("/{id}/delete")
    public ModelAndView deleteCustomer(@PathVariable Long id){
        Optional<Customer> customer = iCustomerService.findById(id);
        if(customer.isPresent()){
            ModelAndView modelAndView = new ModelAndView("redirect:/");
            iCustomerService.remove(id);
            return modelAndView;
        }else{
            return new ModelAndView("error404");
        }
    }
    @GetMapping("/{id}/view")
    public ModelAndView viewCustomer(@PathVariable Long id){
        Optional<Customer> customer = iCustomerService.findById(id);
        if(customer.isPresent()){
            ModelAndView modelAndView = new ModelAndView("view");
            modelAndView.addObject("customer",customer.get());
            return modelAndView;
        }else{
            return new ModelAndView("error404");
        }
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewProvince(@PathVariable Long id, @PageableDefault(size = 5) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("list");
        Page<Customer> customers = iCustomerService.searchByProvince(id,pageable);
        if(!customers.isEmpty()){
            modelAndView.addObject("customers",customers);
            //modelAndView.addObject("province",provinceService.findById(id));
            return modelAndView;
        }else {
            return new ModelAndView("error404");
        }
    }

}
