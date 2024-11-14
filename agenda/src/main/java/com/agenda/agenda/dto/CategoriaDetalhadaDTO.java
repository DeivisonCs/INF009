package com.agenda.agenda.dto;

import java.util.List;

import com.agenda.agenda.model.Categoria;

import lombok.Getter;

@Getter
public class CategoriaDetalhadaDTO {
    private Long id;
    private String nome;
    private List<ContatoDTO> contatos;

    public CategoriaDetalhadaDTO (Categoria categoria, List<ContatoDTO> contatos){
        this.id = categoria.getId();
        this.nome = categoria.getNome();
        this.contatos = contatos;
    }
}
