package repository.customer_type.impl;

import model.Customer;
import model.CustomerType;
import repository.customer.impl.BaseRepository;
import repository.customer_type.ICustomerTypeRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepository implements ICustomerTypeRepository {
    private BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_ALL_CUSTOMERS = "select * from customer_type";
    @Override
    public List<CustomerType> selectAllCustomerType() {
        List<CustomerType> customerTypes = new ArrayList<>();
        try {
            //PreparedStatement
            PreparedStatement preparedStatement = baseRepository.getConnection()
                    .prepareStatement(SELECT_ALL_CUSTOMERS);
            //executeQuery : select
            //executeUpdate: insert, update, delete.
            ResultSet resultSet = preparedStatement.executeQuery();
            CustomerType customerType;
            while (resultSet.next()) {
                customerType = new CustomerType();
                customerType.setCustomer_type_id(resultSet.getInt("customer_id"));
                customerType.setCustomer_type_name(resultSet.getString("customer_type_name"));
                customerTypes.add(customerType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerTypes;
    }
}
