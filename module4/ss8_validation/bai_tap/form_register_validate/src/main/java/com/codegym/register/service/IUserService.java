package com.codegym.register.service;

import com.codegym.register.model.User;
import com.codegym.register.repository.IUserRepository;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    void saveUser(User user);
    User findUserById(Long id);
    void deleteUserById(Long id);
}
