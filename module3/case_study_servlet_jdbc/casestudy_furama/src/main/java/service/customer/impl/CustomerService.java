package service.customer.impl;

import model.Customer;
import repository.customer.ICustomerRepository;

import repository.customer.impl.CustomerRepository;
import service.customer.ICustomerService;

import java.sql.SQLException;
import java.util.List;

public class CustomerService implements ICustomerService {
    private ICustomerRepository iCustomerRepository = new CustomerRepository();
    @Override
    public List<Customer> selectAllCustomers() {
       return iCustomerRepository.selectAllCustomers();
    }

    @Override
    public Customer selectCustomer(int id) {
        return iCustomerRepository.selectCustomer(id);
    }

    @Override
    public int getTotalCustomer() {
        return iCustomerRepository.getTotalCustomer();
    }

    @Override
    public List<Customer> pagingCustomer(int index) {
        return iCustomerRepository.pagingCustomer(index);
    }

    @Override
    public void insertCustomer(Customer customer) throws SQLException {
            iCustomerRepository.insertCustomer(customer);
    }

    @Override
    public void updateCustomer(Customer customer) throws SQLException {
         iCustomerRepository.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(int id) throws SQLException {
        iCustomerRepository.deleteCustomer(id);
    }

    @Override
    public List<Customer> selectCustomerByName(String name) {
        return iCustomerRepository.selectCustomerByName(name);
    }
}
