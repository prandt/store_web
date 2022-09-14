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
import com.rprandt.store.dto.AddressDTO;
import com.rprandt.store.dto.UserDTO;
import com.rprandt.store.dto.UserNewDTO;
import com.rprandt.store.repository.RoleRepository;
import com.rprandt.store.repository.UserRepository;
import com.rprandt.store.service.exceptions.ObjectNotFoundException;

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

    public boolean isEmailExists(String email){
        try {
            return repository.findByEmail(email) != null;
        } catch (Exception e) {
            return true;
        }
    }

    public void save(UserNewDTO userNewDTO){
        String email = userNewDTO.getEmail();
        if(!isEmailExists(email)){
            User obj = convertUserNewDTO(userNewDTO);
            obj.setPassword(
                bCryptPasswordEncoder.encode(obj.getPassword())
            );
            Role userRole = roleRepository.findByAuthority("USER");
            obj.getAuthorities().add(userRole);
            repository.insert(obj);
        }
        else {
            System.out.println("Nao pode salvar pois o email já existe");
        }
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
        return obj.orElseThrow(() -> new ObjectNotFoundException("User not found"));
    }

    public void update(String id, User obj){
        obj = find(id);
        obj.setId(id);
        repository.save(obj);
    }

    public void addAdrress(String userId, AddressDTO obj){
        // User user = find(userId);
        
    }

    public User convertUserNewDTO(UserNewDTO userNewDTO){
        User user = new User(
            null,
            userNewDTO.getName(),
            userNewDTO.getEmail(),
            userNewDTO.getPassword()
        );
        user.addAddressToAddresses(userNewDTO.getAddress());
        return user;
    }
}
