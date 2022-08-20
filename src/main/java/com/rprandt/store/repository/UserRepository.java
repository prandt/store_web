package com.rprandt.store.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rprandt.store.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
   // User findByEmail(String email);
}
