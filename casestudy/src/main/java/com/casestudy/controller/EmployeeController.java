package com.casestudy.controller;

import com.casestudy.model.employee.Employee;
import com.casestudy.service.employee.IDivisionService;
import com.casestudy.service.employee.IEducationDegreeService;
import com.casestudy.service.employee.IEmployeeService;
import com.casestudy.service.employee.IPositionService;
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
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IEducationDegreeService degreeService;
    @Autowired
    private IPositionService positionService;
    @Autowired
    private IDivisionService divisionService;

    @GetMapping("")
    public ModelAndView listEmployee(@RequestParam(name = "nameE", required = false, defaultValue = "") String nameEmployee, @PageableDefault(size = 5) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("employee/list");
//        Page<Employee> page = employeeService.findAll(pageable);
        Page<Employee> page = employeeService.searchByName(nameEmployee, pageable);
        long totalItems = page.getTotalElements();
        modelAndView.addObject("currentPage",pageable.getPageNumber() + 1);
        modelAndView.addObject("totalItems",totalItems);
        modelAndView.addObject("nameE",nameEmployee);
        modelAndView.addObject("employees",page);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("employee/create");
        modelAndView.addObject("employee", new Employee());
        modelAndView.addObject("educationDegrees",degreeService.findAll());
        modelAndView.addObject("positions",positionService.findAll());
        modelAndView.addObject("divisions",divisionService.findAll());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(Employee employee) {
        ModelAndView modelAndView = new ModelAndView("redirect:/employee");
        employeeService.save(employee);
        return modelAndView;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditForm(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("employee/edit");
        Optional<Employee> employee = employeeService.findById(id);
        if(employee.isPresent()){
            modelAndView.addObject("employee",employee.get());
            modelAndView.addObject("educationDegrees",degreeService.findAll());
            modelAndView.addObject("positions",positionService.findAll());
            modelAndView.addObject("divisions",divisionService.findAll());
            return modelAndView;
        }else {
            return new ModelAndView("error404");
        }
    }
    @PostMapping("/update")
    public ModelAndView updateCustomer(Employee employee, RedirectAttributes redirectAttributes){
        ModelAndView modelAndView = new ModelAndView("redirect:/employee");
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("message","Updated successfully");
        return modelAndView;
    }
    @GetMapping("/{id}/delete")
    public ModelAndView deleteCustomer(@PathVariable Long id){
        Optional<Employee> employee = employeeService.findById(id);
        if(employee.isPresent()){
            ModelAndView modelAndView = new ModelAndView("redirect:/employee");
            employeeService.remove(id);
            return modelAndView;
        }else{
            return new ModelAndView("error404");
        }
    }

}
