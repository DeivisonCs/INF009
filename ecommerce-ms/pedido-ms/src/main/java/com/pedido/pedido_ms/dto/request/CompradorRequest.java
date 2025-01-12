package com.pedido.pedido_ms.dto.request;

import com.pedido.pedido_ms.dto.EnderecoDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CompradorRequest {

    @NotNull(message = "Nome do comprador não deve ser nulo")
    @NotBlank(message = "Nome do comprador não deve estar em branco")
    private String name;
    
    @NotNull(message = "CPF do comprador não deve ser nulo")
    @NotBlank(message = "CPF do comprador não deve estar em branco")
    private String cpf;

    @NotNull(message = "Número para contato do comprador não deve ser nulo")
    @NotBlank(message = "Número para contato do comprador não deve estar em branco")
    private String contactNumber;

    @NotNull(message = "Email para contato do comprador não deve ser nulo")
    @NotBlank(message = "Email para contato do comprador não deve estar em branco")
    private String email;

    private EnderecoDTO address;
    
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

    public EnderecoDTO getAddress() {
        return address;
    }
}
