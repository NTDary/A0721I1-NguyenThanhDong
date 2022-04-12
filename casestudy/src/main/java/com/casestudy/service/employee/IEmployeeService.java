package com.casestudy.service.employee;

import com.casestudy.model.employee.Employee;
import com.casestudy.repository.employee.IEmployeeRepository;
import com.casestudy.service.IGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService extends IGeneralService<Employee> {
    Page<Employee> findAll(Pageable pageable);
    Page<Employee> searchByName(String nameEmployee, Pageable pageable);
}
