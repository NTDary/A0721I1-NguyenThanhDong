package com.code.gym.service;

import com.code.gym.model.Test;
import com.code.gym.repository.ITestRepository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ITestService{
    List<Test> findAll();
    void saveTest(Test test);
    void deleteTestById(Long id);
    Test findTestById(Long id);

}
