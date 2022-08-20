package com.rprandt.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rprandt.store.domain.Product;
import com.rprandt.store.repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public void save(Product obj){
        try {
            productRepository.save(obj);
        } catch (Exception e) {
        }
    }

}
