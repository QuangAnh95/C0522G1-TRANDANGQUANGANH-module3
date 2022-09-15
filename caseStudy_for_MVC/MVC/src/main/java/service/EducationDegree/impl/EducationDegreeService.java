package service.EducationDegree.impl;

import model.EducationDegree;
import repository.EducationDegree.IEducationDegreeRepository;
import repository.EducationDegree.impl.EducationDegreeRepository;
import service.EducationDegree.IEducationDegreeService;

import java.util.List;

public class EducationDegreeService implements IEducationDegreeService {
    private IEducationDegreeRepository iEducationDegreeRepository = new EducationDegreeRepository();
    @Override
    public List<EducationDegree> findAll() {
        return iEducationDegreeRepository.findAll();
    }
}
