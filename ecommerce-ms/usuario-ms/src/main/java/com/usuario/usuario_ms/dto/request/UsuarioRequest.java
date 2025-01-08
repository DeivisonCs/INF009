package com.usuario.usuario_ms.dto.request;

import com.usuario.usuario_ms.dto.EnderecoDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UsuarioRequest {
    
    @NotBlank(message = "Informe o nome")
    @NotNull(message = "Nome não pode nulo")
    private String name;

    @NotBlank(message = "Informe seu número")
    @NotNull(message = "Número não pode nulo")
    private String contactNumber;

    private EnderecoDTO address;

    @NotBlank(message = "Informe o CPF")
    @NotNull(message = "CPF não pode nulo")
    private String cpf;

    @NotBlank(message = "Informe o email")
    @NotNull(message = "Email não pode nulo")
    private String email;

    @NotBlank(message = "Informe a senha")
    @NotNull(message = "Senha não pode nula")
    private String password;

    public String getName() {
        return name;
    }

    public EnderecoDTO getAddress() {
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

    
}
