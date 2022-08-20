package com.rprandt.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rprandt.store.domain.Product;
import com.rprandt.store.repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository repo;

    public List<Product> findAll(){
        return repo.findAll();
    }

    public Product find(String id){
        Optional<Product> obj = repo.findById(id);
        return obj.orElseThrow();
    }

    public void save(Product obj){
        try {
            repo.save(obj);
        } catch (Exception e) {
        }
    }

}
