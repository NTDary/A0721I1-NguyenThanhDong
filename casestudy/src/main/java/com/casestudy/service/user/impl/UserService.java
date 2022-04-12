package com.casestudy.service.user.impl;

import com.casestudy.model.user.Role;
import com.casestudy.model.user.User;
import com.casestudy.repository.user.IRoleRepository;
import com.casestudy.repository.user.IUserRepository;
import com.casestudy.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UserService  implements IUserService,UserDetailsService{

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username);

        if (user == null) {
            throw new UsernameNotFoundException("user not found");
        }
//        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
//        GrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
//        grantList.add(authority);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Set<Role> roles = user.getRoles();
        for (Role role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole_name()));
        }
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), grantedAuthorities
        );
    }

    @Override
    public Iterable<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public User findByName(String username) {
        return null;
    }
}
