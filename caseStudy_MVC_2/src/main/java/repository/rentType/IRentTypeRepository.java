package repository.rentType;

import model.RentType;

import java.util.List;

public interface IRentTypeRepository {
    List<RentType> findAll();
}
