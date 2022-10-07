package service.facilityType.impl;

import model.FacilityType;
import repository.facilityType.IFacilityTypeRepository;
import repository.facilityType.impl.FacilityTypeRepository;
import service.facilityType.IFacilityTypeService;

import java.util.List;

public class FacilityTypeService implements IFacilityTypeService {
    private IFacilityTypeRepository facilityTypeRepository = new FacilityTypeRepository();
    @Override
    public List<FacilityType> findAll() {
        return facilityTypeRepository.findAll();
    }
}
