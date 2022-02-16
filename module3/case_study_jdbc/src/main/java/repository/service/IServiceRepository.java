package repository.service;

import model.Customer;
import model.Service;

import java.sql.SQLException;
import java.util.List;

public interface IServiceRepository {
    List<Service> selectAllService();
    public Service selectService(int id);
    public void updateService(Service service) throws SQLException;
    public int getTotalService();
    public List<Service> pagingService(int index);
    public void createService(Service service) throws SQLException;
    void deleteService(int id);
    List<Service> searchService(String name, int min_type_id,int max_type_id,int min,int max);
}
