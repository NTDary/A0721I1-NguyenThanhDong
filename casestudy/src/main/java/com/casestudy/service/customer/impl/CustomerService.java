package com.casestudy.service.customer.impl;

import com.casestudy.model.customer.Customer;
import com.casestudy.model.employee.Employee;
import com.casestudy.repository.customer.ICustomerRepository;
import com.casestudy.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> searchByName(String nameCustomer, Pageable pageable) {
        return customerRepository.searchByName(nameCustomer,pageable);
    }

    @Override
    public Page<Customer> searchCS(String name,Pageable pageable) {
        Page<Customer> temp = customerRepository.searchCS(name,pageable);
        return temp;
    }

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }
}
