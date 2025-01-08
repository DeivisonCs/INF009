package com.usuario.usuario_ms.dto;

import com.usuario.usuario_ms.model.Endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EnderecoDTO {

    @NotBlank(message = "Informe o CEP")
    @NotNull(message = "CEP não pode nulo")
    private String cep;

    @NotBlank(message = "Informe a rua")
    @NotBlank(message = "Rua não pode nula")
    private String street;

    @NotBlank(message = "Informe o número")
    @NotBlank(message = "Número não pode nulo")
    private String number;

    public EnderecoDTO(){}
    
    public EnderecoDTO (Endereco address) {
        this.cep = address.getCep();
        this.number = address.getNumber();
        this.street = address.getStreet();
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
