package com.agenda.agenda.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContatoRequest {
    
    @Valid
    @NotNull(message = "Por favor, informe o nome")
    private String nome;

    @Valid
    @NotNull(message = "Por favor, informe o número")
    private String telefone;
    private String email;
    
    @Valid
    @NotNull(message = "Por favor, informe a categoria")
    private Long categoriaId;

    // public ContatoRequest(Contato contato){
    //     this.nome = contato.getNome();
    //     this.email = contato.getEmail();
    //     this.telefone = contato.getTelefone();
    //     this.categoriaId = contato.getCategoria().getNome();
    // }
}
