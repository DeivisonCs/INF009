package com.agenda.agenda.dto;

import com.agenda.agenda.model.Contato;

import lombok.Getter;

@Getter
public class ContatoDTO {
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private String categoria;

    public ContatoDTO(Contato contato){
        this.id = contato.getId();
        this.nome = contato.getNome();
        this.email = contato.getEmail();
        this.telefone = contato.getTelefone();
        this.categoria = contato.getCategoria().getNome();
    }
}
