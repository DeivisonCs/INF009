package com.ecommerce.ecommerce.dto;

import java.util.UUID;

import com.ecommerce.ecommerce.model.User;

import lombok.Getter;

@Getter
public class UserDTO {

    private UUID id;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private EnderecoDTO endereco;

    public UserDTO(User user){
        this.id = user.getId();
        this.nome = user.getNome();
        this.email = user.getEmail();
        this.senha = user.getSenha();
        this.telefone = user.getTelefone();
        this.endereco = new EnderecoDTO(user.getEndereco());
    }
}
