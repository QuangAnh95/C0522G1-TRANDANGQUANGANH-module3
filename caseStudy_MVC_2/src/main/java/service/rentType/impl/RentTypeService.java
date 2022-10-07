package service.rentType.impl;

import model.facility.RentType;
import repository.rentType.IRentTypeRepository;
import repository.rentType.impl.RentTypeRepository;
import service.rentType.IRentTypeService;

import java.util.List;

public class RentTypeService implements IRentTypeService {
    private IRentTypeRepository rentTypeRepository = new RentTypeRepository();
    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}
