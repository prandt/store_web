package com.rprandt.store.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.userdetails.UserDetails;

import com.rprandt.store.dto.AddressDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@Getter
@Setter
@NoArgsConstructor
public class User implements UserDetails {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private Set<Role> authorities = new HashSet<>();
	private ArrayList<AddressDTO> addresses = new ArrayList<AddressDTO>();

	public User(String id, String name, String email, String password){
        this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
    }

	public void addAddressToAddresses(AddressDTO addressDTO){
		getAddresses().add(addressDTO);
	}

    @Override
    public String getUsername() {
        return email;
    }

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

    @Override
	public Set<Role> getAuthorities() {
		return authorities;
	}
}
