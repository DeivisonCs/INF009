package com.pedido.pedido_ms.model;

import com.pedido.pedido_ms.dto.request.CompradorRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Comprador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(unique = true)
    private String cpf;
    private String contactNumber;
    private String email;

    @Embedded
    private Endereco address;

    public Comprador(){}

    public Comprador(CompradorRequest buyer){
        this.name = buyer.getName();
        this.cpf = buyer.getCpf();
        this.contactNumber = buyer.getContactNumber();
        this.email = buyer.getEmail();
        this.address = new Endereco(buyer.getAddress());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public Endereco getAddress() {
        return address;
    }

    
}
