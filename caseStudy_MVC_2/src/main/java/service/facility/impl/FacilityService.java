package service.facility.impl;

import model.facility.Facility;
import repository.facility.IFacilityRepository;
import repository.facility.impl.FacilityRepository;
import service.facility.IFacilityService;

import java.util.List;

public class FacilityService implements IFacilityService {
    private IFacilityRepository facilityRepository = new FacilityRepository();
    @Override
    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }

    @Override
    public boolean create(Facility facility) {
        return facilityRepository.create(facility);
    }

    @Override
    public Facility findById(int idFind) {
        return facilityRepository.findById(idFind);
    }

    @Override
    public boolean edit(Facility facility) {
        return facilityRepository.edit(facility);
    }

    @Override
    public boolean delete(int idDelete) {
        return facilityRepository.delete(idDelete);
    }

    @Override
    public List<Facility> search(String nameSearch, String facilityTypeSearch) {
        return facilityRepository.search(nameSearch,facilityTypeSearch);
    }
}
