package com.casestudy.service.customer.impl;

import com.casestudy.model.customer.CustomerType;
import com.casestudy.repository.customer.ICustomerTypeRepository;
import com.casestudy.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomerTypeService implements ICustomerTypeService {

    @Autowired
    private ICustomerTypeRepository customerTypeRepository;

    @Override
    public Iterable<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }

    @Override
    public Optional<CustomerType> findById(Long id) {
        return customerTypeRepository.findById(id);
    }

    @Override
    public void save(CustomerType customerType) {
        customerTypeRepository.save(customerType);
    }

    @Override
    public void remove(Long id) {
        customerTypeRepository.deleteById(id);
    }
}
