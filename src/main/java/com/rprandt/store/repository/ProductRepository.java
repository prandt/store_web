package com.rprandt.store.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rprandt.store.domain.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>{
    
}
