package repository.service.impl;

import model.Customer;
import model.Service;
import repository.customer.impl.BaseRepository;
import repository.service.IServiceRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository implements IServiceRepository {
    BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_ALL_SERVICE = "SELECT * FROM SERVICE";
    private static final String SELECT_PAGE_SERVICE = "select * from service order by service_id limit ?,3";
    private static final String CREATE_SERVICE_SQL = "INSERT INTO service" + "  (service_id, service_name, service_area,service_cost,service_max_people," +
            "rent_type_id,service_type_id,standard_room,description_other_convenience,pool_area,number_of_floors) VALUES " +
            " (?, ?, ?,?,?,?,?,?,?,?,?);";
    private static final String SELECT_SERVICE_BY_ID = "select * from service where service_id =?";
    private static final String UPDATE_SERVICE_SQL = "update service set service_name = ?,service_area= ?, service_cost =? , service_max_people =?," +
            "rent_type_id = ?,service_type_id = ?,standard_room = ?, description_other_convenience=? , pool_area = ?, number_of_floors= ? where service_id = ?";

    @Override
    public List<Service> selectAllService() {
        List<Service> serviceList = new ArrayList<>();
        Connection connection = null;

        try {
            connection = baseRepository.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SELECT_ALL_SERVICE);
            ResultSet resultSet = preparedStatement.executeQuery();
            Service service;
            while (resultSet.next()){
                service = new Service();
                service.setServiceId(resultSet.getInt("service_id"));
                service.setServiceName(resultSet.getString("service_name"));
                service.setServiceArea(resultSet.getInt("service_area"));
                service.setServiceCost(resultSet.getDouble("service_cost"));
                service.setServiceMaxPeople(resultSet.getInt("service_max_people"));
                service.setRentTypeId(resultSet.getInt("rent_type_id"));
                service.setServiceTypeId(resultSet.getInt("service_type_id"));
                service.setStandardRoom(resultSet.getString("standard_room"));
                service.setDescriptionOtherConvenience(resultSet.getString("description_other_convenience"));
                service.setPoolArea(resultSet.getInt("pool_area"));
                service.setNumberOfFloors(resultSet.getInt("number_of_floors"));
                serviceList.add(service);
            }
            connection.commit();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return serviceList;
    }

    @Override
    public Service selectService(int id) {
        Service service = null;
        Connection conn = null;
        ResultSet resultSet = null;
        PreparedStatement pstmt = null;

        try{
            conn = baseRepository.getConnection();
            conn.setAutoCommit(false);

            pstmt = conn.prepareStatement(SELECT_SERVICE_BY_ID);
            pstmt.setInt(1, id);
            resultSet = pstmt.executeQuery();

            while (resultSet.next()){
                int serviceId = resultSet.getInt("service_id");
                String serviceName = resultSet.getString("service_name");
                int serviceArea = resultSet.getInt("service_area");
                Double serviceCost = resultSet.getDouble("service_cost");
                int serviceMaxPeople = resultSet.getInt("service_max_people");
                int rentType = resultSet.getInt("rent_type_id");
                int serviceTypeId = resultSet.getInt("service_type_id");
                String standardRoom = resultSet.getString("standard_room");
                String description = resultSet.getString("description_other_convenience");
                int poolArea = resultSet.getInt("pool_area");
                int numberOfFloors = resultSet.getInt("number_of_floors");
                service = new Service(serviceId,serviceName,serviceArea,serviceCost,serviceMaxPeople,
                        rentType,serviceTypeId,standardRoom,description,poolArea,numberOfFloors);

            }
            conn.commit();
        }catch (SQLException e){
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return service;
    }

    @Override
    public void updateService(Service service) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = baseRepository.getConnection();
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(UPDATE_SERVICE_SQL);

            pstmt.setString(1,service.getServiceName());
            pstmt.setInt(2,service.getServiceArea());
            pstmt.setDouble(3,service.getServiceCost());
            pstmt.setInt(4,service.getServiceMaxPeople());
            pstmt.setInt(5,service.getRentTypeId());
            pstmt.setInt(6,service.getServiceTypeId());
            pstmt.setString(7,service.getStandardRoom());
            pstmt.setString(8,service.getDescriptionOtherConvenience());
            pstmt.setInt(9,service.getPoolArea());
            pstmt.setInt(10,service.getNumberOfFloors());
            pstmt.setInt(11,service.getServiceId());

            pstmt.execute();
            conn.commit();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public int getTotalService() {
        String query = "select count(*) from service";
        try {
            //PreparedStatement
            PreparedStatement preparedStatement = baseRepository.getConnection()
                    .prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (Exception e) {

        }
        return 0;
    }

    @Override
    public List<Service> pagingService(int index) {
        List<Service> serviceList = new ArrayList<>();
        Connection connection = null;

        try {
            connection = baseRepository.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SELECT_PAGE_SERVICE);
            preparedStatement.setInt(1,(index -1) * 3);
            ResultSet resultSet = preparedStatement.executeQuery();
            Service service;
            while (resultSet.next()){
                service = new Service();
                service.setServiceId(resultSet.getInt("service_id"));
                service.setServiceName(resultSet.getString("service_name"));
                service.setServiceArea(resultSet.getInt("service_area"));
                service.setServiceCost(resultSet.getDouble("service_cost"));
                service.setServiceMaxPeople(resultSet.getInt("service_max_people"));
                service.setRentTypeId(resultSet.getInt("rent_type_id"));
                service.setServiceTypeId(resultSet.getInt("service_type_id"));
                service.setStandardRoom(resultSet.getString("standard_room"));
                service.setDescriptionOtherConvenience(resultSet.getString("description_other_convenience"));
                service.setPoolArea(resultSet.getInt("pool_area"));
                service.setNumberOfFloors(resultSet.getInt("number_of_floors"));
                serviceList.add(service);
            }
            connection.commit();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return serviceList;
    }

    @Override
    public void createService(Service service) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = baseRepository.getConnection();
            conn.setAutoCommit(false);

            pstmt = conn.prepareStatement(CREATE_SERVICE_SQL);
            pstmt.setInt(1,service.getServiceId());
            pstmt.setString(2,service.getServiceName());
            pstmt.setInt(3,service.getServiceArea());
            pstmt.setDouble(4,service.getServiceCost());
            pstmt.setInt(5,service.getServiceMaxPeople());
            pstmt.setInt(6,service.getRentTypeId());
            pstmt.setInt(7,service.getServiceTypeId());
            pstmt.setString(8,service.getStandardRoom());
            pstmt.setString(9,service.getDescriptionOtherConvenience());
            pstmt.setInt(10,service.getPoolArea());
            pstmt.setInt(11,service.getNumberOfFloors());

            pstmt.execute();
            conn.commit();

        }catch (SQLException e){
            e.printStackTrace();
            conn.rollback();
        }
    }
}
