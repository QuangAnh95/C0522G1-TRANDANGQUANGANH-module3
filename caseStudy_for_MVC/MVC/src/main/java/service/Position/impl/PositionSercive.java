package service.Position.impl;

import model.Position;
import repository.Position.IPositionRepository;
import repository.Position.impl.PositionRepository;
import service.Position.IPositionSercive;

import java.util.List;

public class PositionSercive implements IPositionSercive {
    private IPositionRepository iPositionRepository = new PositionRepository();

    @Override
    public List<Position> findAll() {
        return iPositionRepository.findAll();
    }
}
