package service.customer.impl;

import model.Customer;
import repository.customer.ICustomerRepository;

import repository.customer.impl.CustomerRepository;
import service.customer.ICustomerService;

import java.sql.SQLException;
import java.util.HashMap;
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
    public HashMap<String, String> insertCustomer(Customer customer) throws SQLException {
        //Tạo map
        HashMap<String, String> map = new HashMap<>();

        //Tạo class mới để kiểm tra
        //1.	Mã Khách hàng có định dạng là KH-XXXX (X là số từ 0-9)
//        if(!customer.getCustomer_name().matches("^KH-\\d{4}$")){
//            map.put("name", "Lỗi định dạng name");
//        }
        if(!customer.getCustomer_phone().matches("((090|091)|(.?(84.?).?+90|.?(84.?).?+91))\\d{7}$")){
            map.put("phone","Lỗi định dạng phone");
        }
        if(!customer.getCustomer_id_card().matches("^(\\d{9}|\\d{12})$")){
            map.put("idCard","Lỗi định dạng CMND");
        }
        if(!customer.getCustomer_email().matches("^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$")){
            map.put("email","Lỗi định dạng email");
        }
        if(!customer.getCustomer_birthday().matches("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$")){
            map.put("date","Lỗi định dạng date");
        }
        if(map.isEmpty()){
            iCustomerRepository.insertCustomer(customer);
        }
        return map;
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
