package com.casestudy.controller;

import com.casestudy.model.contract.Contract;
import com.casestudy.model.customer.Customer;
import com.casestudy.service.contract.IAttachServiceS;
import com.casestudy.service.contract.IContractDetailService;
import com.casestudy.service.contract.IContractService;
import com.casestudy.service.customer.ICustomerService;
import com.casestudy.service.employee.IEmployeeService;
import com.casestudy.service.service.IServiceS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService contractService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IServiceS serviceS;

    @GetMapping("")
    public ModelAndView listCustomer(@RequestParam(name = "nameC", required = false, defaultValue = "") String idContract, @PageableDefault(size = 5) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("contract/list");
//        Page<Employee> page = employeeService.findAll(pageable);
        Page<Contract> page = contractService.searchById(idContract, pageable);
        long totalItems = page.getTotalElements();
        modelAndView.addObject("currentPage",pageable.getPageNumber() + 1);
        modelAndView.addObject("totalItems",totalItems);
        modelAndView.addObject("nameC",idContract);
        modelAndView.addObject("contracts",page);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("contract/create");
        modelAndView.addObject("contract", new Contract());
        modelAndView.addObject("customers",customerService.findAll());
        modelAndView.addObject("services",serviceS.findAll());
        modelAndView.addObject("employees",employeeService.findAll());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(Contract contract) {
        ModelAndView modelAndView = new ModelAndView("redirect:/contract");
        contractService.save(contract);
        return modelAndView;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditForm(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("contract/edit");
        Optional<Contract> contract = contractService.findById(id);
        if(contract.isPresent()){
            modelAndView.addObject("contract",contract.get());
            modelAndView.addObject("customers",customerService.findAll());
            modelAndView.addObject("services",serviceS.findAll());
            modelAndView.addObject("employees",employeeService.findAll());
            return modelAndView;
        }else {
            return new ModelAndView("error404");
        }
    }
    @PostMapping("/update")
    public ModelAndView updateCustomer(Contract contract, RedirectAttributes redirectAttributes){
        ModelAndView modelAndView = new ModelAndView("redirect:/contract");
        contractService.save(contract);
        redirectAttributes.addFlashAttribute("message","Updated successfully");
        return modelAndView;
    }
    @GetMapping("/{id}/delete")
    public ModelAndView deleteCustomer(@PathVariable Long id){
        Optional<Contract> contract = contractService.findById(id);
        if(contract.isPresent()){
            ModelAndView modelAndView = new ModelAndView("redirect:/contract");
            contractService.remove(id);
            return modelAndView;
        }else{
            return new ModelAndView("error404");
        }
    }

}
