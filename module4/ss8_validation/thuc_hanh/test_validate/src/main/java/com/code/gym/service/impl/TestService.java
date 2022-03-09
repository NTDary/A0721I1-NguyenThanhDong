package com.code.gym.service.impl;

import com.code.gym.model.Test;
import com.code.gym.repository.ITestRepository;
import com.code.gym.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService implements ITestService {
    @Autowired
    private ITestRepository iTestRepository;
    @Override
    public List<Test> findAll() {
        return iTestRepository.findAll();
    }

    @Override
    public void saveTest(Test test) {
        iTestRepository.save(test);
    }


    @Override
    public void deleteTestById(Long id) {
        iTestRepository.deleteById(id);
    }

    @Override
    public Test findTestById(Long id) {
        return iTestRepository.findById(id).orElse(null);
    }
}
