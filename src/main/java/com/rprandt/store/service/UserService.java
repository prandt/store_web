package com.rprandt.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rprandt.store.domain.User;
import com.rprandt.store.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

    @Autowired
	private UserRepository repository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("Email not found");
		}
		return user;
    }

    public void save(User obj){
        obj.setPassword(
            bCryptPasswordEncoder.encode(obj.getPassword())
        );
        repository.save(obj);
    }
    
}
