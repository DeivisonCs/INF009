package com.ecommerce.ecommerce.dto.request;

import com.ecommerce.ecommerce.dto.EnderecoDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @NotNull(message = "Nome nao deve ser nulo")
    @NotBlank(message = "Nome nao deve estar em branco")
    @Schema(name = "nome", example = "Maria Eduarda")
    private String nome;
    
    @NotNull(message = "Email nao deve ser nulo")
    @NotBlank(message = "Email nao deve estar em branco")
    @Schema(name = "email", example = "mariaDuda@gmail.com")
    private String email;
    
    @NotNull(message = "Senha nao deve ser nula")
    @NotBlank(message = "Senha nao deve estar em branco")
    @Schema(name = "senha", example = "mariaDuda123")
    private String senha;
    
    @NotNull(message = "Telefone nao deve ser nulo")
    @NotBlank(message = "Telefone nao deve estar em branco")
    @Schema(name = "telefone", example = "(71) 99828-1919")
    private String telefone;
    
    @Valid
    @NotNull(message = "Endereco nao deve ser nulo")
    private EnderecoDTO endereco;

    public void setSenha(String senha){
        this.senha = senha;
    }
}
