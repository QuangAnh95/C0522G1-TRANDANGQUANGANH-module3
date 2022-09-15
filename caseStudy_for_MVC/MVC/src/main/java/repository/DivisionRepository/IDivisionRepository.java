package repository.DivisionRepository;

import model.Division;

import java.util.List;

public interface IDivisionRepository {
    List<Division> findAll();
}
