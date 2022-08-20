package com.rprandt.store.domain;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Product {
    @Id
    private String id;
    private String name;
    private Long price;
    private Long amout;
}
