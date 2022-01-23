package service.customer;

import model.Customer;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface ICustomerService {
    public List<Customer> selectAllCustomers();
    public Customer selectCustomer(int id);
    public int getTotalCustomer();
    public List<Customer> pagingCustomer(int index);
    public HashMap<String, String> insertCustomer(Customer customer) throws SQLException;
    public void updateCustomer(Customer customer) throws SQLException;
    public void deleteCustomer(int id) throws SQLException;
    public List<Customer> selectCustomerByName(String name);
}
