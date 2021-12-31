package service;

import controller.repository.ICustomerRepository;
import controller.repository.impl.CustomerRepository;
import model.Customer;

import java.util.List;

public class CustomerService implements ICustomerService{
    private ICustomerRepository iCustomerRepository = new CustomerRepository();


    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }
}
