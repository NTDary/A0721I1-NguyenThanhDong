package com.casestudy.service.contract.impl;

import com.casestudy.model.contract.AttachService;
import com.casestudy.repository.contract.IAttachServiceRepository;
import com.casestudy.service.contract.IAttachServiceS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AttachServiceS implements IAttachServiceS {
    @Autowired
    private IAttachServiceRepository attachServiceRepository;
    @Override
    public Iterable<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }

    @Override
    public Optional<AttachService> findById(Long id) {
        return attachServiceRepository.findById(id);
    }

    @Override
    public void save(AttachService attachService) {
        attachServiceRepository.save(attachService);
    }

    @Override
    public void remove(Long id) {
        attachServiceRepository.deleteById(id);
    }
}
