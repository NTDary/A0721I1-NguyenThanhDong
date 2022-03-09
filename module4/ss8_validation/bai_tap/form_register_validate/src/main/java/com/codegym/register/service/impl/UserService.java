package com.codegym.register.service.impl;

import com.codegym.register.model.User;
import com.codegym.register.repository.IUserRepository;
import com.codegym.register.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public List<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        iUserRepository.save(user);
    }

    @Override
    public User findUserById(Long id) {
        return iUserRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUserById(Long id) {
        iUserRepository.deleteById(id);
    }
}
