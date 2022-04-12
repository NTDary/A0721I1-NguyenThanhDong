package com.casestudy.service.employee.impl;

import com.casestudy.model.employee.Employee;
import com.casestudy.repository.employee.IEmployeeRepository;
import com.casestudy.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void remove(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable){
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Page<Employee> searchByName(String nameEmployee, Pageable pageable) {
        return employeeRepository.searchByName(nameEmployee, pageable);
    }

}
