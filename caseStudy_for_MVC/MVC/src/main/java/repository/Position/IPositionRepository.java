package repository.Position;

import model.Position;

import java.util.List;

public interface IPositionRepository {
    List<Position> findAll();
}
