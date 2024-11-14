package com.agenda.agenda.model;

import java.util.List;

import com.agenda.agenda.dto.CategoriaDTO;
import com.agenda.agenda.dto.request.CategoriaRequest;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(unique=true)
    private String nome;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.REMOVE)
    private List<Contato> contatos;

    public Categoria(CategoriaDTO categoria){
        this.nome = categoria.getNome();
    }

    public Categoria(CategoriaRequest categoria){
        this.nome = categoria.getNome();
    }
}
