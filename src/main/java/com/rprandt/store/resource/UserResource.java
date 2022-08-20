package com.rprandt.store.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rprandt.store.domain.User;
import com.rprandt.store.service.UserService;


@RestController
@RequestMapping(value="/users")
public class UserResource {
    @Autowired
    private UserService service;

    @PostMapping("/create")
    public void save(@RequestBody User obj){
        service.save(obj);
    }

    @GetMapping("/{id}")
    public User find(@PathVariable String id) {
       return service.find(id);
    }
    

}
