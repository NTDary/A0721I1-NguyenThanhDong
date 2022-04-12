package com.casestudy.service.user.impl;

import com.casestudy.model.user.Role;
import com.casestudy.repository.user.IRoleRepository;
import com.casestudy.service.user.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService implements IRoleService{
    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public Role findByName(String roleName) {
        return roleRepository.findByName(roleName);
    }

    @Override
    public Iterable<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Role role) {

    }

    @Override
    public void remove(Long id) {

    }
}
