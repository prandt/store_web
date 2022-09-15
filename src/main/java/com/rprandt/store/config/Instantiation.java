package com.rprandt.store.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rprandt.store.domain.Role;
import com.rprandt.store.repository.RoleRepository;


@Configuration
public class Instantiation implements CommandLineRunner{
   @Autowired
   private RoleRepository roleRepository;
  
    @Override
    public void run(String... args) throws Exception {

        if(roleRepository.findByAuthority("ADMIN") == null){
            Role adminRole = new Role(null, "ADMIN");
            roleRepository.insert(adminRole);
            System.out.println("ADMIN ROLE CREATED");
        }
        if(roleRepository.findByAuthority("USER") == null){
            Role userRole = new Role(null, "USER");
            roleRepository.insert(userRole);
            System.out.println("USER ROLE CREATED");
        }
        
    }
}
