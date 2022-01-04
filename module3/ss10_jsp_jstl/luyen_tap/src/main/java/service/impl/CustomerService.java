package service.impl;

import model.Customer;
import repository.ICustomer;
import repository.impl.CustomerRepository;
import service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    private ICustomer iCustomer = new CustomerRepository();

    @Override
    public List<Customer> findAll() {
        return iCustomer.findAll();
    }
}
