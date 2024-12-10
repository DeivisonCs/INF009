package com.ecommerce.ecommerce.model;

import java.util.List;

import com.ecommerce.ecommerce.dto.request.CategoriaRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Categoria {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(unique=true)
    private String nome;

    @OneToMany
    private List<Produto> produtos;

    public Categoria(CategoriaRequest categoria){
        this.nome = categoria.getNome();
    }
}
