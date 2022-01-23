package service.service_type.impl;

import model.ServiceType;
import repository.service_type.IServiceTypeRepository;
import repository.service_type.impl.ServiceTypeRepository;
import service.service_type.IServiceTypeService;

import java.util.List;

public class ServiceTypeService implements IServiceTypeService {
    IServiceTypeRepository iServiceTypeRepository = new ServiceTypeRepository();
    @Override
    public List<ServiceType> selectAllServiceType() {
        return iServiceTypeRepository.selectAllServiceType();
    }
}
