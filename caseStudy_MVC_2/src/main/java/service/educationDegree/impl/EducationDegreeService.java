package service.educationDegree.impl;

import model.employee.EducationDegree;
import repository.educationDegree.IEducationDegreeRepository;
import repository.educationDegree.impl.EducationDegreeRepository;
import service.educationDegree.IEducationDegreeService;

import java.util.List;

public class EducationDegreeService implements IEducationDegreeService {
    private IEducationDegreeRepository educationDegreeRepository = new EducationDegreeRepository();
    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }
}
