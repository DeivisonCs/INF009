package com.pedido.pedido_ms.dto;

import com.pedido.pedido_ms.model.Endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EnderecoDTO {

    @NotNull(message = "CEP não deve ser nulo")
    @NotBlank(message = "CEP não deve estar em branco")
    private String cep;

    @NotNull(message = "Rua não deve ser nula")
    @NotBlank(message = "Rua não deve estar em branco")
    private String street;

    @NotNull(message = "Número não deve ser nulo")
    @NotBlank(message = "Número não deve estar em branco")
    private String number;

    public EnderecoDTO(){}
    
    public EnderecoDTO(Endereco address){
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
