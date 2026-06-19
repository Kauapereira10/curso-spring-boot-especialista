package com.udemy.curso.kaua.produtosapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {

//  Para diz que este ID é um Primary Key
    @Id
    @Column
    private String id;

    @Column(name = "name")
    private String name;

    @Column
    private String description;

    @Column
    private Double price;



}
