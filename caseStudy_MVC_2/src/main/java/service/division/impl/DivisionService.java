package service.division.impl;

import model.employee.Division;
import repository.division.IDivisionRepository;
import repository.division.impl.DivisionRepository;
import service.division.IDivisionService;

import java.util.List;

public class DivisionService implements IDivisionService {
    private IDivisionRepository divisionRepository = new DivisionRepository();
    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }
}
