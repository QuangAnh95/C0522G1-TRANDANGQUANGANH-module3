package service.position.impl;

import model.employee.Position;
import repository.position.IPositionRepository;
import repository.position.impl.PositionRepository;
import service.position.IPositionService;

import java.util.List;

public class PositionService implements IPositionService {
    private IPositionRepository positionRepository = new PositionRepository();
    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }
}
