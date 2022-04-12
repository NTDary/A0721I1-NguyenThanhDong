package com.casestudy.service.employee.impl;

import com.casestudy.model.employee.EducationDegree;
import com.casestudy.repository.employee.IEducationDegreeRepository;
import com.casestudy.service.employee.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EducationDegreeService implements IEducationDegreeService {
    @Autowired
    private IEducationDegreeRepository degreeRepository;

    @Override
    public Iterable<EducationDegree> findAll() {
        return degreeRepository.findAll();
    }

    @Override
    public Optional<EducationDegree> findById(Long id) {
        return degreeRepository.findById(id);
    }

    @Override
    public void save(EducationDegree educationDegree) {
        degreeRepository.save(educationDegree);
    }

    @Override
    public void remove(Long id) {
        degreeRepository.deleteById(id);
    }
}
