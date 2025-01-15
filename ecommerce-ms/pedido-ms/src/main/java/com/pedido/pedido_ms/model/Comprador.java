package com.pedido.pedido_ms.model;

import com.pedido.pedido_ms.client.usuarioMs.UsuarioClientResponse;

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

    public Comprador(UsuarioClientResponse user){
        this.name = user.name();
        this.cpf = user.cpf();
        this.contactNumber = user.contactNumber();
        this.email = user.email();
        this.address = new Endereco(user.address());
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
