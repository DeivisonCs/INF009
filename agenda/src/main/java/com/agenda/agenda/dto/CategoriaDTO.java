package com.agenda.agenda.dto;

import com.agenda.agenda.model.Categoria;

import lombok.Getter;

@Getter
public class CategoriaDTO {
    private Long id;
    private String name;
    
    public CategoriaDTO (Categoria categoria){
        this.id = categoria.getId();
        this.name = categoria.getNome();
    }
}
