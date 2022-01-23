package service.customer_type.impl;

import model.CustomerType;
import repository.customer_type.ICustomerTypeRepository;
import repository.customer_type.impl.CustomerTypeRepository;
import service.customer_type.ICustomerTypeService;

import java.util.List;

public class CustomerTypeService implements ICustomerTypeService {
    private ICustomerTypeRepository iCustomerTypeRepository = new CustomerTypeRepository();
    @Override
    public List<CustomerType> selectAllCustomerType() {
        return iCustomerTypeRepository.selectAllCustomerType();
    }
}
