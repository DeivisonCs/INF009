package com.biblioteca.biblioteca.model;

import com.biblioteca.biblioteca.dto.request.LivroRequest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titulo;
    private String autor;
    private Integer anoPublicacao;

    public Livro(LivroRequest livro){
        this.autor = livro.autor();
        this.titulo = livro.titulo();
        this.anoPublicacao = livro.anoPublicacao();
    }
}
