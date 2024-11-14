package com.agenda.agenda.dto;

import com.agenda.agenda.model.Categoria;

import lombok.Getter;

@Getter
public class CategoriaDTO {
    private Long id;
    private String nome;
    
    public CategoriaDTO (Categoria categoria){
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }
}
