package service.service;

import model.Service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface IService {
    List<Service> selectAllService();
    List<Service> pagingService(int index);
    int getTotalService();
    HashMap<String, String> createService(Service service) throws SQLException;

    public Service selectService(int id);
    public void updateService(Service service) throws SQLException;
}
