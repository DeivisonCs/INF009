package com.biblioteca.biblioteca.dto;

import com.biblioteca.biblioteca.model.Livro;

import lombok.AllArgsConstructor;

@AllArgsConstructor
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
