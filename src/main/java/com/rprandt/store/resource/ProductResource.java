package com.rprandt.store.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rprandt.store.domain.Product;
import com.rprandt.store.service.ProductService;

@RestController
@RequestMapping(value="/products")
public class ProductResource {
    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product find(@PathVariable String id){
        return service.find(id);
    }

    @PostMapping
    public void save(@RequestBody Product obj){
        service.save(obj);
    }
}
