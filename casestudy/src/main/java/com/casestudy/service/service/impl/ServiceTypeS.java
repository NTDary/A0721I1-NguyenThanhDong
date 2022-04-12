package com.casestudy.service.service.impl;

import com.casestudy.model.service.ServiceType;
import com.casestudy.repository.service.IServiceTypeRepository;
import com.casestudy.service.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ServiceTypeS implements IServiceTypeService {
    @Autowired
    private IServiceTypeRepository serviceTypeRepository;
    @Override
    public Iterable<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }

    @Override
    public Optional<ServiceType> findById(Long id) {
        return serviceTypeRepository.findById(id);
    }

    @Override
    public void save(ServiceType serviceType) {
        serviceTypeRepository.save(serviceType);
    }

    @Override
    public void remove(Long id) {
        serviceTypeRepository.deleteById(id);
    }
}
