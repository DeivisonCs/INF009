package com.ecommerce.ecommerce.dto;

import com.ecommerce.ecommerce.model.Categoria;

import lombok.Getter;

@Getter
public class CategoriaDTO {
    private Long id;
    private String nome;

    public CategoriaDTO(Categoria categoria){
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }
}
