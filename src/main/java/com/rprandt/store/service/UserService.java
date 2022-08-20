package com.rprandt.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.rprandt.store.domain.User;
import com.rprandt.store.repository.UserRepository;

public class UserService {
    @Autowired
    private UserRepository repo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void save(User obj){
        obj.setPassword(bCryptPasswordEncoder.encode(obj.getPassword()));
        repo.save(obj);
    }
}
