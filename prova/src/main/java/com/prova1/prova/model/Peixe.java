package com.prova1.prova.model;

import com.prova1.prova.dto.request.PeixeRequest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;

@Entity
@Builder
public class Peixe {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String nome;
    private String especie;
    private Double preco;
    private Integer quantidadeEmEstoque;

    public Peixe(){}

    public Peixe(PeixeRequest peixe){
        this.nome = peixe.getNome();
        this.especie = peixe.getEspecie();
        this.preco = peixe.getPreco();
        this.quantidadeEmEstoque = peixe.getQuantidadeEmEstoque();
    }

    public Peixe(Long id, String especie, String nome, Double preco, Integer quantidadeEmEstoque) {
        this.especie = especie;
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public Peixe(Peixe oldData, PeixeRequest newData){
        this.id = oldData.getId();
        this.nome = newData.getNome()!=null? newData.getNome() : oldData.getNome();
        this.especie = newData.getEspecie()!=null? newData.getEspecie() : oldData.getEspecie();
        this.preco = newData.getPreco()!=null? newData.getPreco() : oldData.getPreco();
        this.quantidadeEmEstoque = newData.getQuantidadeEmEstoque()!=null? newData.getQuantidadeEmEstoque() : oldData.getQuantidadeEmEstoque();
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
