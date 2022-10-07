package service.attachFacility.impl;

import model.AttachFacility;
import repository.attachFacility.IAttachFacilityRepository;
import repository.attachFacility.impl.AttachFacilityRepository;
import service.attachFacility.IAttachFacilityService;

import java.util.List;

public class AttachFacilityService implements IAttachFacilityService {
    private IAttachFacilityRepository attachFacilityRepository = new AttachFacilityRepository();
    @Override
    public List<AttachFacility> findAll() {
        return attachFacilityRepository.findAll();
    }
}
