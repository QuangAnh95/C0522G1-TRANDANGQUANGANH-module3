package repository.division;

import model.employee.Division;

import java.util.List;

public interface IDivisionRepository {
    List<Division> findAll();
}
