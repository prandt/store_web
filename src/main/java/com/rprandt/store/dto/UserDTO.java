package com.rprandt.store.dto;

import javax.persistence.Id;

import com.rprandt.store.domain.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    @Id
    private String id;
    private String name;
    private String email;
    public UserDTO(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }
}
