package repository.impl;

import model.Customer;
import repository.ICustomer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomer {
    private static List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer("Mai Văn Hoàn", "1983-08-20", "Hà Nội", "https://www.w3schools.com/howto/img_avatar2.png"));
        customerList.add(new Customer("Nguyễn Văn Nam", "1983-08-21", "Bắc Giang", "https://www.w3schools.com/howto/img_avatar2.png"));
        customerList.add(new Customer("Nguyễn Thái Hòa", "1983-08-22", "Nam Định", "https://www.w3schools.com/howto/img_avatar2.png"));
        customerList.add(new Customer("Trần Đăng Khoa", "1983-08-17", "Hà Tây", "https://www.w3schools.com/howto/img_avatar2.png"));
        customerList.add(new Customer("Nguyễn Đình Thi", "1983-08-19", "Hà Nội", "https://www.w3schools.com/howto/img_avatar2.png"));
    }

    @Override
    public List<Customer> findAll() {
        return customerList;
    }
}
