package com.rprandt.store.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rprandt.store.domain.Role;

@Repository
public interface RoleRepository extends MongoRepository<Role, String>{
    Role findByAuthority(String authority);
}
