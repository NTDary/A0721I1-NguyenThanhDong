package repository;

import model.Customer;

import java.util.List;

public interface ICustomer {
    List<Customer> findAll();
}
