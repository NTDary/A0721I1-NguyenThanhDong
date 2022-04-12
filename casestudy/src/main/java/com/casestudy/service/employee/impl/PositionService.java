package com.casestudy.service.employee.impl;

import com.casestudy.model.employee.Position;
import com.casestudy.repository.employee.IPositionRepository;
import com.casestudy.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PositionService implements IPositionService {
    @Autowired
    private IPositionRepository positionRepository;

    @Override
    public Iterable<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public Optional<Position> findById(Long id) {
        return positionRepository.findById(id);
    }

    @Override
    public void save(Position position) {
        positionRepository.save(position);
    }

    @Override
    public void remove(Long id) {
        positionRepository.deleteById(id);
    }
}
