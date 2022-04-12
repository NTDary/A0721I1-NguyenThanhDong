package com.casestudy.service.employee.impl;

import com.casestudy.model.employee.Division;
import com.casestudy.repository.employee.IDivisionRepository;
import com.casestudy.service.employee.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DivisionService implements IDivisionService {
    @Autowired
    private IDivisionRepository divisionRepository;
    @Override
    public Iterable<Division> findAll() {
        return divisionRepository.findAll();
    }

    @Override
    public Optional<Division> findById(Long id) {
        return divisionRepository.findById(id);
    }

    @Override
    public void save(Division division) {
        divisionRepository.save(division);
    }

    @Override
    public void remove(Long id) {
        divisionRepository.deleteById(id);
    }
}
