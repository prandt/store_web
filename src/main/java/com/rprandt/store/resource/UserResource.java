package com.rprandt.store.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rprandt.store.domain.User;
import com.rprandt.store.dto.UserDTO;
import com.rprandt.store.service.UserService;


@RestController
@RequestMapping(value="/users")
public class UserResource {
    @Autowired
    private UserService service;

    @GetMapping
    public List<UserDTO> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public User find(@PathVariable String id) {
       return service.find(id);
    }
}
