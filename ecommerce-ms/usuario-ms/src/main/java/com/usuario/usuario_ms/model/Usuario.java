package com.usuario.usuario_ms.model;

import com.usuario.usuario_ms.dto.request.UsuarioRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;

    @Embedded
    private Endereco address;

    @Column(unique = true)
    private String cpf;
    private String email;
    private String contactNumber;
    private String password;

    public Usuario(){}

    public Usuario (UsuarioRequest user){
        this.name = user.getName();
        this.email = user.getEmail();
        this.cpf = user.getCpf();
        this.address = new Endereco(user.getAddress());
        this.password = user.getPassword();
        this.contactNumber = user.getContactNumber();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Endereco getAddress() {
        return address;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }
    
    public String getContactNumber() {
        return contactNumber;
    }

    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}
