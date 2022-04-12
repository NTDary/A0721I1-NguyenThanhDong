package com.casestudy.service.customer;

import com.casestudy.model.customer.Customer;
import com.casestudy.model.employee.Employee;
import com.casestudy.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService extends IGeneralService<Customer> {
    Page<Customer> searchByName(String nameCustomer, Pageable pageable);
    Page<Customer> searchCS(String name,Pageable pageable);
}
