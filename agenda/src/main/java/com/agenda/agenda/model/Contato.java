package com.agenda.agenda.model;


import com.agenda.agenda.dto.request.ContatoRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    @Column(unique=true)
    private String telefone;

    private String email;

    @ManyToOne()
    private Categoria categoria;

    public Contato(ContatoRequest contato, Categoria categoria){
        this.categoria = categoria;
        this.email = contato.getEmail();
        this.nome = contato.getNome();
        this.telefone = contato.getTelefone();
    }
}
