package com.library.library.dto;

import com.library.library.model.Livro;

import lombok.Getter;

@Getter
public class LivroDTO {
    private Long id;
    private String titulo;
    private String autor;
    private Integer anoPublicacao;

    public LivroDTO(Livro livro){
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.autor = livro.getAutor();
        this.anoPublicacao = livro.getAnoPublicacao();
    }
}
