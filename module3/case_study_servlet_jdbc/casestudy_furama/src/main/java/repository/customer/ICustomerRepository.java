package repository.customer;

import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerRepository {
    public List<Customer> selectAllCustomers();
    public Customer selectCustomer(int id);
    public void insertCustomer(Customer customer) throws SQLException;
    public int getTotalCustomer();
    public List<Customer> pagingCustomer(int index);
    public void updateCustomer(Customer customer) throws SQLException;
    public void deleteCustomer(int id) throws SQLException;
    public List<Customer> selectCustomerByName(String name);
}
