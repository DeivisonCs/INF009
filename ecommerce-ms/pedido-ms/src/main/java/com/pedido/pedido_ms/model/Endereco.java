package com.pedido.pedido_ms.model;

import com.pedido.pedido_ms.dto.EnderecoDTO;

import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco {

    private String cep;
    private String street;
    private String number;

    public Endereco (){}

    public Endereco(EnderecoDTO address){
        this.cep = address.getCep();
        this.street = address.getStreet();
        this.number = address.getNumber();
    }

    public String getCep() {
        return cep;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }
}