package repository.rent_type;

import model.RentType;

import java.util.List;

public interface IRentTypeRepository {
    List<RentType> selectAllRentType();
}
