package com.casestudy.controller;

import com.casestudy.model.contract.ContractDetail;
import com.casestudy.model.employee.Employee;
import com.casestudy.service.contract.IAttachServiceS;
import com.casestudy.service.contract.IContractDetailService;
import com.casestudy.service.contract.IContractService;
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
@RequestMapping("/contract-detail")
public class ContractDetailController {
    @Autowired
    private IContractDetailService detailService;
    @Autowired
    private IAttachServiceS attachServiceS;
    @Autowired
    private IContractService contractService;

    @GetMapping("")
    public ModelAndView listEmployee(@RequestParam(name = "nameE", required = false, defaultValue = "") String nameCT, @PageableDefault(size = 5) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("contract_detail/list");
//        Page<Employee> page = employeeService.findAll(pageable);
        Page<ContractDetail> page = detailService.searchById(nameCT, pageable);
        long totalItems = page.getTotalElements();
        modelAndView.addObject("currentPage",pageable.getPageNumber() + 1);
        modelAndView.addObject("totalItems",totalItems);
        modelAndView.addObject("nameE",nameCT);
        modelAndView.addObject("contractDetails",page);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("contract_detail/create");
        modelAndView.addObject("contractDetail", new ContractDetail());
        modelAndView.addObject("contracts",contractService.findAll());
        modelAndView.addObject("attachServices",attachServiceS.findAll());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(ContractDetail contractDetail) {
        ModelAndView modelAndView = new ModelAndView("redirect:/contract-detail");
        detailService.save(contractDetail);
        return modelAndView;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditForm(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("contract_detail/edit");
        Optional<ContractDetail> contractDetail = detailService.findById(id);
        if(contractDetail.isPresent()){
            modelAndView.addObject("contractDetail",contractDetail.get());
            modelAndView.addObject("contracts",contractService.findAll());
            modelAndView.addObject("attachServices",attachServiceS.findAll());
            return modelAndView;
        }else {
            return new ModelAndView("error404");
        }
    }
    @PostMapping("/update")
    public ModelAndView updateCustomer(ContractDetail contractDetail, RedirectAttributes redirectAttributes){
        ModelAndView modelAndView = new ModelAndView("redirect:/contract-detail");
        detailService.save(contractDetail);
        redirectAttributes.addFlashAttribute("message","Updated successfully");
        return modelAndView;
    }
    @GetMapping("/{id}/delete")
    public ModelAndView deleteCustomer(@PathVariable Long id){
        Optional<ContractDetail> contractDetail = detailService.findById(id);
        if(contractDetail.isPresent()){
            ModelAndView modelAndView = new ModelAndView("redirect:/contract-detail");
            detailService.remove(id);
            return modelAndView;
        }else{
            return new ModelAndView("error404");
        }
    }
}
