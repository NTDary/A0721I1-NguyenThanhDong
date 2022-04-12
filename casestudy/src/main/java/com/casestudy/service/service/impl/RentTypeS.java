package com.casestudy.service.service.impl;

import com.casestudy.model.service.RentType;
import com.casestudy.repository.service.IRentTypeRepository;
import com.casestudy.service.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RentTypeS implements IRentTypeService {
    @Autowired
    private IRentTypeRepository rentTypeRepository;
    @Override
    public Iterable<RentType> findAll() {
        return rentTypeRepository.findAll();
    }

    @Override
    public Optional<RentType> findById(Long id) {
        return rentTypeRepository.findById(id);
    }

    @Override
    public void save(RentType rentType) {
        rentTypeRepository.save(rentType);
    }

    @Override
    public void remove(Long id) {
        rentTypeRepository.deleteById(id);
    }
}
