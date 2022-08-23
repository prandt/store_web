package com.rprandt.store.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserNewDTO {
    public String name;
    public String email;
    public String password;
    public AddressDTO address;
}
