package com.library.library.model;

import com.library.library.dto.request.LivroRequest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titulo;
    private String autor;
    private Integer anoPublicacao;

    public Livro(LivroRequest livro){
        this.titulo = livro.titulo();
        this.autor = livro.autor();
        this.anoPublicacao = livro.anoPublicacao();
    }
}
