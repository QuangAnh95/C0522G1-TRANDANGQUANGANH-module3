package service.Division.impl;

import model.Division;
import repository.DivisionRepository.IDivisionRepository;
import repository.DivisionRepository.impl.DivisionRepository;
import service.Division.IDivisionService;

import java.util.List;

public class DivisionService implements IDivisionService {
    private IDivisionRepository iDivisionRepository = new DivisionRepository();

    @Override
    public List<Division> findAll() {
        return iDivisionRepository.findAll();
    }
}
