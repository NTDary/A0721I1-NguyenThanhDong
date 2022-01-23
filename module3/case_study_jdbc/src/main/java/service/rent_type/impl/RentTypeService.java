package service.rent_type.impl;

import model.RentType;
import repository.rent_type.IRentTypeRepository;
import repository.rent_type.impl.RentTypeRepository;
import service.rent_type.IRentTypeService;

import java.util.List;

public class RentTypeService implements IRentTypeService {
    IRentTypeRepository iRentTypeRepository = new RentTypeRepository();

    @Override
    public List<RentType> selectAllRentType() {
        return iRentTypeRepository.selectAllRentType();
    }
}
