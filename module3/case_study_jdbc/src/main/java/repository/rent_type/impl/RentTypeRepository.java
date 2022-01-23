package repository.rent_type.impl;

import model.RentType;
import repository.customer.impl.BaseRepository;
import repository.rent_type.IRentTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentTypeRepository implements IRentTypeRepository {
    BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_ALL_RENT_TYPE = "select * from rent_type";
    @Override
    public List<RentType> selectAllRentType() {
        List<RentType> rentTypeList = new ArrayList<>();

        Connection cnn = null;
        ResultSet resultSet = null;

        try {
            cnn = baseRepository.getConnection();
            cnn.setAutoCommit(false);

            PreparedStatement preparedStatement = cnn.prepareStatement(SELECT_ALL_RENT_TYPE);

            resultSet = preparedStatement.executeQuery();
            RentType rentType;

            while (resultSet.next()){
                rentType = new RentType();
                rentType.setRentTypeId(resultSet.getInt("rent_type_id"));
                rentType.setRentTypeName(resultSet.getString("rent_type_name"));
                rentType.setRentTypeCost(resultSet.getDouble("rent_type_cost"));
                rentTypeList.add(rentType);
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

        return rentTypeList;
    }
}
