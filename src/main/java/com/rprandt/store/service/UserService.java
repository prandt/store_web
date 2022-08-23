package com.rprandt.store.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rprandt.store.domain.Role;
import com.rprandt.store.domain.User;
import com.rprandt.store.dto.UserDTO;
import com.rprandt.store.repository.RoleRepository;
import com.rprandt.store.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

    @Autowired
	private UserRepository repository;

    @Autowired
    private RoleRepository roleRepository;

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

        Role admin = roleRepository.findByAuthority("ADMIN");
        Role user = roleRepository.findByAuthority("USER");
        obj.getAuthorities().add(admin);
        obj.getAuthorities().add(user);
        repository.save(obj);
    }

    public List<UserDTO> findAll(){
        List<User> userList = repository.findAll();
        List<UserDTO> userListDTO = userList.stream()
            .map(obj -> new UserDTO(obj))
            .collect(Collectors.toList());
        return userListDTO;
    }

    public User find(String id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow();
    }
}
