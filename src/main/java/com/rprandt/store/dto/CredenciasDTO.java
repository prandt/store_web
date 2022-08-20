package com.rprandt.store.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CredenciasDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String email;
	private String password;
	
    
}
