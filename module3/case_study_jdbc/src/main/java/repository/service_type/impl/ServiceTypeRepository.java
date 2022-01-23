package repository.service_type.impl;

import model.ServiceType;
import repository.customer.impl.BaseRepository;
import repository.service_type.IServiceTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeRepository implements IServiceTypeRepository {
    BaseRepository baseRepository = new BaseRepository();

    private final static String SELECT_ALL_SERVICETYPE = "SELECT * FROM SERVICE_TYPE";

    @Override
    public List<ServiceType> selectAllServiceType() {
        List<ServiceType> serviceTypeList = new ArrayList<>();
        Connection cnn = null;
        ResultSet resultSet = null;

        try{
            cnn = baseRepository.getConnection();
            cnn.setAutoCommit(false);

            PreparedStatement preparedStatement = cnn.prepareStatement(SELECT_ALL_SERVICETYPE);
            resultSet = preparedStatement.executeQuery();
            ServiceType serviceType;
            while (resultSet.next()){
                serviceType = new ServiceType();
                serviceType.setServiceTypeId(resultSet.getInt("service_type_id"));
                serviceType.setServiceTypeName(resultSet.getString("service_type_name"));
                serviceTypeList.add(serviceType);
            }
            cnn.commit();
        }catch (SQLException e){
            e.printStackTrace();
            try {
                cnn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return serviceTypeList;
    }
}
