package com.rprandt.store.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rprandt.store.domain.User;
import com.rprandt.store.dto.AddressDTO;
import com.rprandt.store.dto.UserDTO;
import com.rprandt.store.service.UserService;


@RestController
@RequestMapping(value="/users")
public class UserResource {
    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<UserDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> find(@PathVariable String id) {
        User body = service.find(id);
        return ResponseEntity.ok().body(body);
    }

    @PostMapping("{id}/address")
    public ResponseEntity<Void> addAdrress(@PathVariable String userId, AddressDTO obj){
        service.addAdrress(userId, obj);
        return ResponseEntity.ok().build();
    }

}
