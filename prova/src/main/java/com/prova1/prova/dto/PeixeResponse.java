package com.prova1.prova.dto;

import com.prova1.prova.model.Peixe;

public class PeixeResponse {
    Long id;
    String nome;
    String especie;
    Double preco;
    Integer quantidadeEmEstoque;

    public PeixeResponse(Peixe peixe){
        this.id = peixe.getId();
        this.nome = peixe.getNome();
        this.especie = peixe.getEspecie();
        this.preco = peixe.getPreco();
        this.quantidadeEmEstoque = peixe.getQuantidadeEmEstoque();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecie() {
        return especie;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    
}
