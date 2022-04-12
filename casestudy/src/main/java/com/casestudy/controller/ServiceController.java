package com.casestudy.controller;

import com.casestudy.model.employee.Employee;
import com.casestudy.model.service.Service;
import com.casestudy.service.service.IRentTypeService;
import com.casestudy.service.service.IServiceS;
import com.casestudy.service.service.IServiceTypeService;
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
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private IServiceS serviceS;
    @Autowired
    private IRentTypeService rentTypeService;
    @Autowired
    private IServiceTypeService serviceTypeService;

    @GetMapping("")
    public ModelAndView listEmployee(@RequestParam(name = "nameE", required = false, defaultValue = "") String nameService, @PageableDefault(size = 5) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("service/list");
//        Page<Employee> page = employeeService.findAll(pageable);
        Page<Service> page = serviceS.searchByName(nameService, pageable);
        long totalItems = page.getTotalElements();
        modelAndView.addObject("currentPage",pageable.getPageNumber() + 1);
        modelAndView.addObject("totalItems",totalItems);
        modelAndView.addObject("nameE",nameService);
        modelAndView.addObject("services",page);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("service/create");
        modelAndView.addObject("service", new Service());
        modelAndView.addObject("rentTypes",rentTypeService.findAll());
        modelAndView.addObject("serviceTypes",serviceTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(Service service) {
        ModelAndView modelAndView = new ModelAndView("redirect:/service");
        serviceS.save(service);
        return modelAndView;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditForm(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("service/edit");
        Optional<Service> service = serviceS.findById(id);
        if(service.isPresent()){
            modelAndView.addObject("service",service.get());
            modelAndView.addObject("rentTypes",rentTypeService.findAll());
            modelAndView.addObject("serviceTypes",serviceTypeService.findAll());
            return modelAndView;
        }else {
            return new ModelAndView("error404");
        }
    }
    @PostMapping("/update")
    public ModelAndView updateCustomer(Service service, RedirectAttributes redirectAttributes){
        ModelAndView modelAndView = new ModelAndView("redirect:/service");
        serviceS.save(service);
        redirectAttributes.addFlashAttribute("message","Updated successfully");
        return modelAndView;
    }
    @GetMapping("/{id}/delete")
    public ModelAndView deleteCustomer(@PathVariable Long id){
        Optional<Service> service = serviceS.findById(id);
        if(service.isPresent()){
            ModelAndView modelAndView = new ModelAndView("redirect:/service");
            serviceS.remove(id);
            return modelAndView;
        }else{
            return new ModelAndView("error404");
        }
    }
}
