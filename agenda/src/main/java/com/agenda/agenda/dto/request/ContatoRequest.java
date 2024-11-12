package com.agenda.agenda.dto.request;

import com.agenda.agenda.model.Contato;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContatoRequest {
    private String nome;
    private String telefone;
    private String email;
    private Long categoriaId;

    // public ContatoRequest(Contato contato){
    //     this.nome = contato.getNome();
    //     this.email = contato.getEmail();
    //     this.telefone = contato.getTelefone();
    //     this.categoriaId = contato.getCategoria().getNome();
    // }
}
