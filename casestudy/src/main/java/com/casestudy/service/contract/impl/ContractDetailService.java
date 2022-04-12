package com.casestudy.service.contract.impl;

import com.casestudy.model.contract.Contract;
import com.casestudy.model.contract.ContractDetail;
import com.casestudy.repository.contract.IContractDetailRepository;
import com.casestudy.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository contractDetailRepository;

    @Override
    public Iterable<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public Optional<ContractDetail> findById(Long id) {
        return contractDetailRepository.findById(id);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public void remove(Long id) {
        contractDetailRepository.deleteById(id);
    }

    @Override
    public Page<ContractDetail> searchById(String id, Pageable pageable) {
        return contractDetailRepository.searchById(id,pageable);
    }
}
