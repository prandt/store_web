package com.rprandt.store.config;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Instantiation implements CommandLineRunner{
   // @Autowired
   // private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
       /* Role adminRole = new Role(null, "ADMIN");
        Role userRole = new Role(null, "USER");
        roleRepository.saveAll(Arrays.asList(adminRole, userRole));*/
    }
}
