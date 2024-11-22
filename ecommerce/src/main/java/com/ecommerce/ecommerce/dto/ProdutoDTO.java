package com.ecommerce.ecommerce.dto;

import com.ecommerce.ecommerce.mapper.CategoriaMapper;
import com.ecommerce.ecommerce.model.Produto;

import lombok.Getter;

@Getter
public class ProdutoDTO {

    private Long id;
    private String nome;
    private String descricao; 
    private Double preco;
    private int quantidadeEstoque;
    private CategoriaDTO categoria;

    public ProdutoDTO(Produto produto){
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();
        this.quantidadeEstoque = produto.getQuantidadeEstoque();
        this.categoria = CategoriaMapper.toDto(produto.getCategoria());
    }
}
