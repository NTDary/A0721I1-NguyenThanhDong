package com.casestudy.service.service.impl;

import com.casestudy.model.service.Service;
import com.casestudy.repository.service.IServiceRepository;
import com.casestudy.service.service.IServiceS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceS implements IServiceS {
    @Autowired
    private IServiceRepository serviceRepository;

    @Override
    public Page<Service> searchByName(String nameService, Pageable pageable) {
        return serviceRepository.searchByName(nameService, pageable);
    }

    @Override
    public Iterable<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Optional<Service> findById(Long id) {
        return serviceRepository.findById(id);
    }

    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void remove(Long id) {
        serviceRepository.deleteById(id);
    }
}
