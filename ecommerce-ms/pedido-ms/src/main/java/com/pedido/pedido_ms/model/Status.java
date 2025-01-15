package com.pedido.pedido_ms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String name;

    public Status(){}

    public Status(String name){
        this.name = name;
    }
    
    public Long getId() {
        return id;
    }  
   
    public String getName() {
        return name;
    }  
    
}
