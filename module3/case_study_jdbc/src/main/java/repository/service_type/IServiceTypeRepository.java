package repository.service_type;

import model.ServiceType;

import java.util.List;

public interface IServiceTypeRepository {
    List<ServiceType> selectAllServiceType();
}
