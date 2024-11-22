package com.ecommerce.ecommerce.model;

import com.ecommerce.ecommerce.dto.request.ProdutoRequest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Produto {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String nome;
    private String descricao; 
    private Double preco;
    private int quantidadeEstoque;

    @ManyToOne
    private Categoria categoria;

    public Produto(ProdutoRequest produto, Categoria categoria){
        this.nome = produto.getNome();
        this.quantidadeEstoque = produto.getQuantidadeEstoque();
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();
        this.categoria = categoria;
    }
}
// nome, descrição, preço, quantidade em estoque e
// categoria.
