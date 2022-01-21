package repository.customer.impl;

import model.Customer;
import repository.customer.ICustomerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {

    private BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_ALL_CUSTOMERS = "select * from customer";
    private static final String INSERT_CUSTOMER_SQL = "INSERT INTO customer" + "  (customer_type_id, customer_name, customer_birthday,customer_gender,customer_id_card," +
            "customer_phone,customer_email,customer_address) VALUES " +
            " (?, ?, ?,?,?,?,?,?);";
    private static final String SELECT_PAGE_CUSTOMERS = "select * from customer order by customer_id limit ?,3";
    private static final String SELECT_CUSTOMER_BY_ID = "select * from customer where customer_id =?";
    private static final String UPDATE_CUSTOMER_SQL = "update customer set customer_type_id = ?,customer_name= ?, customer_birthday =? , customer_gender =?," +
            "customer_id_card = ?,customer_phone = ?,customer_email = ?, customer_address=? where customer_id = ?";

    private static final String DELETE_CUSTOMER_SQL = "delete from customer where customer_id = ?;";
    private static final String SELECT_CUSTOMER_BY_NAME_SQL = "select * from customer where customer_name like ?";

    @Override
    public int getTotalCustomer() {
        String query = "select count(*) from customer";
        try {
            //PreparedStatement
            PreparedStatement preparedStatement = baseRepository.getConnection()
                    .prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (Exception e) {

        }
        return 0;
    }

    @Override
    public List<Customer> pagingCustomer(int index) {
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection()
                    .prepareStatement(SELECT_PAGE_CUSTOMERS);
            preparedStatement.setInt(1, (index - 1) * 3);
            ResultSet resultSet = preparedStatement.executeQuery();
            Customer customer;
            while (resultSet.next()) {
                customer = new Customer();
                customer.setCustomer_id(resultSet.getInt("customer_id"));
                customer.setCustomer_type_id(resultSet.getInt("customer_type_id"));
                customer.setCustomer_name(resultSet.getString("customer_name"));
                customer.setCustomer_birthday(resultSet.getString("customer_birthday"));
                customer.setCustomer_gender(resultSet.getInt("customer_gender"));
                customer.setCustomer_id_card(resultSet.getString("customer_id_card"));
                customer.setCustomer_phone(resultSet.getString("customer_phone"));
                customer.setCustomer_email(resultSet.getString("customer_email"));
                customer.setCustomer_address(resultSet.getString("customer_address"));
                customerList.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerList;
    }
    
    @Override
    public List<Customer> selectAllCustomers() {
        List<Customer> customerList = new ArrayList<>();
        try {

            //PreparedStatement
            PreparedStatement preparedStatement = baseRepository.getConnection()
                    .prepareStatement(SELECT_ALL_CUSTOMERS);
            //executeQuery : select
            //executeUpdate: insert, update, delete.
            ResultSet resultSet = preparedStatement.executeQuery();
            Customer customer;
            while (resultSet.next()) {
                customer = new Customer();
                customer.setCustomer_id(resultSet.getInt("customer_id"));
                customer.setCustomer_type_id(resultSet.getInt("customer_type_id"));
                customer.setCustomer_name(resultSet.getString("customer_name"));
                customer.setCustomer_birthday(resultSet.getString("customer_birthday"));
                customer.setCustomer_gender(resultSet.getInt("customer_gender"));
                customer.setCustomer_id_card(resultSet.getString("customer_id_card"));
                customer.setCustomer_phone(resultSet.getString("customer_phone"));
                customer.setCustomer_email(resultSet.getString("customer_email"));
                customer.setCustomer_address(resultSet.getString("customer_address"));
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    @Override
    public Customer selectCustomer(int id) {
        Customer customer = null;
        // Step 1: Establishing a Connection
        try (Connection connection = baseRepository.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id_type = rs.getInt("customer_type_id");
                String name = rs.getString("customer_name");
                String birthday = rs.getString("customer_birthday");
                int gender = rs.getInt("customer_gender");
                String id_card = rs.getString("customer_id_card");
                String phone = rs.getString("customer_phone");
                String email = rs.getString("customer_email");
                String address = rs.getString("customer_address");
                customer = new Customer(id_type,name,birthday,gender,id_card,
                        phone,email,address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public void updateCustomer(Customer customer) throws SQLException {
        Connection conn = null;
        // for insert a new customer
        PreparedStatement pstmt = null;
        // for assign permision to customer
        // for getting customer id
        ResultSet rs = null;
        try{
            conn = baseRepository.getConnection();
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(UPDATE_CUSTOMER_SQL);
            pstmt.setInt(1, customer.getCustomer_type_id());
            pstmt.setString(2, customer.getCustomer_name());
            pstmt.setString(3, customer.getCustomer_birthday());
            pstmt.setInt(4, customer.getCustomer_gender());
            pstmt.setString(5, customer.getCustomer_id_card());
            pstmt.setString(6, customer.getCustomer_phone());
            pstmt.setString(7, customer.getCustomer_email());
            pstmt.setString(8, customer.getCustomer_address());
            pstmt.setInt(9, customer.getCustomer_id());
            int rowUpdated = pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteCustomer(int id) throws SQLException {
        Connection conn = null;
        // for insert a new customer
        PreparedStatement pstmt = null;
        // for assign permision to customer
        // for getting customer id
        ResultSet rs = null;
        try{
            conn = baseRepository.getConnection();
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(DELETE_CUSTOMER_SQL);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Customer> selectCustomerByName(String name) {
        List<Customer> customerList = new ArrayList<>();
        Connection conn = null;
        // for insert a new customer
        PreparedStatement pstmt = null;
        // for assign permision to customer
        // for getting customer id
        ResultSet rs = null;
        try{
            conn = baseRepository.getConnection();
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(SELECT_CUSTOMER_BY_NAME_SQL);
            pstmt.setString(1, '%'+name+'%');
            rs = pstmt.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int customer_id = rs.getInt("customer_id");
                int id_type = rs.getInt("customer_type_id");
                String customer_name = rs.getString("customer_name");
                String birthday = rs.getString("customer_birthday");
                int gender = rs.getInt("customer_gender");
                String id_card = rs.getString("customer_id_card");
                String phone = rs.getString("customer_phone");
                String email = rs.getString("customer_email");
                String address = rs.getString("customer_address");
                customerList.add(new Customer(customer_id,id_type,customer_name,birthday,gender,id_card,
                        phone,email,address));
            }
            conn.commit();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return customerList;
    }

    @Override
    public void insertCustomer(Customer customer) throws SQLException {
        Connection conn = null;
        // for insert a new customer
        PreparedStatement pstmt = null;
        // for assign permision to customer
        // for getting customer id
        ResultSet rs = null;
        try {
            conn = baseRepository.getConnection();
            // set auto commit to false
            conn.setAutoCommit(false);
            //
            // Insert Customer
            //
            pstmt = conn.prepareStatement(INSERT_CUSTOMER_SQL);
            pstmt.setInt(1, customer.getCustomer_type_id());
            pstmt.setString(2, customer.getCustomer_name());
            pstmt.setString(3, customer.getCustomer_birthday());
            pstmt.setInt(4, customer.getCustomer_gender());
            pstmt.setString(5, customer.getCustomer_id_card());
            pstmt.setString(6, customer.getCustomer_phone());
            pstmt.setString(7, customer.getCustomer_email());
            pstmt.setString(8, customer.getCustomer_address());

            pstmt.execute();
            conn.commit();
//            int rowAffected = pstmt.executeUpdate();
//
//            if (rowAffected == 1) {
//                conn.commit();
//            } else {
//                conn.rollback();
//            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

