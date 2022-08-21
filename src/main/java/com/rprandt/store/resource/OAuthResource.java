package com.rprandt.store.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rprandt.store.domain.User;
import com.rprandt.store.service.UserService;

@RestController
@RequestMapping("/oauth")
public class OAuthResource {
    @Autowired
    private UserService userService;

    @PostMapping("/user/create")
    public void save(@RequestBody User obj){
        userService.save(obj);
    }
}
