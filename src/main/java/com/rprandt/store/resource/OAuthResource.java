package com.rprandt.store.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rprandt.store.dto.UserNewDTO;
import com.rprandt.store.service.UserService;

@RestController
@RequestMapping("/oauth")
public class OAuthResource {
    @Autowired
    private UserService userService;

    @PostMapping("/user/create")
    public ResponseEntity<Void> save(@RequestBody UserNewDTO obj){
        userService.save(obj);
        return ResponseEntity.ok().build();
    }
}
