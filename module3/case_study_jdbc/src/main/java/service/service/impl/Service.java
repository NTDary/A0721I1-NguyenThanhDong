package service.service.impl;

import repository.customer_type.ICustomerTypeRepository;
import repository.customer_type.impl.CustomerTypeRepository;
import repository.service.IServiceRepository;
import repository.service.impl.ServiceRepository;
import service.service.IService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class Service implements IService {
    IServiceRepository iServiceRepository = new ServiceRepository();


    @Override
    public List<model.Service> selectAllService() {
        return iServiceRepository.selectAllService();
    }

    @Override
    public List<model.Service> pagingService(int index) {
        return iServiceRepository.pagingService(index);
    }

    @Override
    public int getTotalService() {
        return iServiceRepository.getTotalService();
    }

    @Override
    public HashMap<String, String> createService(model.Service service) throws SQLException {
        HashMap<String, String> map = new HashMap<>();

//        if(!service.getServiceName().matches("^(\\D)")){
//            map.put("name","Loi Name Service");
//        }
        if(map.isEmpty()){
            iServiceRepository.createService(service);
        }
        return map;
    }

    @Override
    public model.Service selectService(int id) {
        return iServiceRepository.selectService(id);
    }

    @Override
    public void updateService(model.Service service) throws SQLException {
            iServiceRepository.updateService(service);
    }
}
