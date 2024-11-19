package com.ecommerce.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank
    private String descricao; 

    @NotNull
    @NotBlank
    private Double preco;

    @NotNull
    private int quantidade;

    @NotNull
    @ManyToOne
    private Categoria categoria;
}
// nome, descrição, preço, quantidade em estoque e
// categoria.
