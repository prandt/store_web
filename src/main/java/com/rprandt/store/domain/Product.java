package com.rprandt.store.domain;

import java.io.Serializable;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String name;
    private Long price;
    private Long amout;
}
